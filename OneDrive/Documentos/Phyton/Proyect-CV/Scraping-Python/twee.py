import tweepy

# Claves de acceso de tu aplicación en Twitter
consumer_key = ""
consumer_secret = ""
access_token = ""
access_token_secret = ""

# Autenticación con la API de Twitter
auth = tweepy.OAuth1UserHandler(consumer_key, consumer_secret, access_token, access_token_secret)

# Crear un objeto de la API
api = tweepy.API(auth)

# Ejemplo: Obtener los últimos tweets de un usuario
user_tweets = api.user_timeline(screen_name="arigameplays", count=10)

# Imprimir los textos de los últimos tweets
for tweet in user_tweets:
    print(tweet.text)
