Hi guys , i decided to build a Telegram bot which gives the user the live prices
Of top 10 Crypto prices to the user. so thats how to do it:
steps:
1- i create id and recived token by using BotFather.
2-in pom.xml i downloaded all the dependencies i needed and getting Telegram API from the Telgram websites
3- in javacrypto class we put our token and id and we create sendmessage funcation to check the bots works and 
if something is wrong with the first part we get notification by main  try catch method.
4-
i used CoinGecko api to recieve all top ten coins i wrote down in list to get the live price.
