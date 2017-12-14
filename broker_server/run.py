from flask import Flask, request, jsonify
import easytrader

GF_KEY_PATH = '/Users/Raymond/python/gf/gf.json'
app = Flask(__name__)
user = easytrader.use('gf')

@app.route('/')
def home():
    return 'hello, 小伙砸'


@app.route('/buy', methods=['POST'])
def buy():
    return 'buy'


@app.route('/sell', methods=['POST'])
def sell():
    return 'sell'

if __name__ == '__main__':
    #user.prepare(GF_KEY_PATH)
    app.run(host='127.0.0.1', port=9100, debug=True)

    #in prd: gunicorn -w 4 -b 127.0.0.1:8080 run:app
