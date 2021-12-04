package me.simpleNumbers.listeners;

import net.mysterymod.api.event.EventHandler;
import net.mysterymod.api.event.message.MessageSendEvent;

public class OnChatMessageSentListener {
  @EventHandler
  public void onSendChatMessage(MessageSendEvent event){
    String s = event.getMessage();
    if(s.toLowerCase().startsWith("/pay ") ||s.toLowerCase().startsWith("/bank ")){
      try {
        String[] splitString = s.split(" ");
        String originalPayment = splitString[2].toLowerCase();
        if(originalPayment.endsWith("k")){
          String amountWithoutLetters = originalPayment.replace("k","").replace(",",".");
          int amountToPay = (int)Math.floor(Float.parseFloat(amountWithoutLetters) * 1000);
          event.setMessage(splitString[0]+" "+splitString[1]+" "+amountToPay);
        }
        if(originalPayment.endsWith("m") || originalPayment.endsWith("mio")){
          String amountWithoutLetters = originalPayment.split("m")[0].replace(",",".");
          int amountToPay = (int)Math.floor(Float.parseFloat(amountWithoutLetters) * 1000000);
          event.setMessage(splitString[0]+" "+splitString[1]+" "+amountToPay);
        }
      }catch (Exception e){}
    }
  }
}
