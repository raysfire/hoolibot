Hoolibot
========

Hoolibot is a simple, Java-based, IRC bot made to do fun things in a Twitch chat. While the current version on this repository is currently customized for the twitch streamer [raysfire](http://raysfi.re/), it can easily be modified to do even more for your own channel. 

Hoolibot utilizes the **[PircBotX library](https://github.com/TheLQ/pircbotx)**, and as such, requires all of the same libraries (**Apache Commons Lang 3, Google Guava, Apache Commons Codec, Slf4j**) in order to properly compile and run.

## Features ##
 - Timed messages
 - Built in delay to prevent a global ban from Twitch's servers
 - Flexibility to support additional features
 - Responses to specific chat commands, such as:
	 - Active "now playing" information for a particular user
	 - Active server IP information for a particular user
	 - FrankerZ

## How to Use ##
To use Hoolibot in it's current state, all that is required is an edit to the Constants class (found in [src/Constants.java](https://github.com/raysfire/hoolibot/blob/master/src/Constants.java)) with the required information. 

From there, the bot should be able to be safely compiled and run. 

To run the bot locally after being compiled, all that is required is navigating to the directory of the .jar file, and running the following command: 

       java -jar <file name>.jar


