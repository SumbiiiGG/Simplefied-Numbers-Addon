package me.simpleNumbers;

import me.simpleNumbers.listeners.OnChatMessageSentListener;
import net.mysterymod.mod.MysteryMod;
import net.mysterymod.mod.addon.Addon;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.logging.Logger;

@Singleton
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SimpleNumbersAddon extends Addon {
  private final Logger logger;
  @Override
  public void onEnable() {
    logger.info("Hello World?");
    OnChatMessageSentListener onChatMessageSentListener = MysteryMod.getInjector().getInstance(OnChatMessageSentListener.class);
    MysteryMod.getInstance().getListenerChannel().registerListener(onChatMessageSentListener);
  }
}
