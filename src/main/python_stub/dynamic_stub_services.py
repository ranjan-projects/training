from flask import Flask, json, jsonify

app = Flask(__name__)


def read_config():
    """fetches a config from json file

        Args:

        Returns:
            array of config
    """
    with open('endpoints_config.json') as config_file:
        config = json.load(config_file)
        return config


def create_endpoint(app, endpoint):
    """Using endpoint object to dynamically expose it

        Args:
            app: self(flask)
            endpoint: endpoint pojo

        Returns:
            array of config
    """
    route = endpoint['route']
    method = endpoint['method']
    name = endpoint['name']
    data = endpoint.get('data', {})

    @app.route(route, methods=[method], endpoint=route)
    def dynamic_endpoint():
        return jsonify({'name': name, 'data': data})
    return dynamic_endpoint


def list_routes():
    print(['%s' % rule for rule in app.url_map.iter_rules()])
    print(app.url_map)


# Main execution
if __name__ == '__main__':
    config_data = read_config()
    endpoints = config_data.get('endpoints', [])
    for endpoint in endpoints:
        create_endpoint(app, endpoint)
    list_routes()
    app.run(debug=True, port=8080)
