package com.tardisgallifrey.teleportmod;

import com.tardisgallifrey.teleportmod.Init.EnchantmentInit;
import com.tardisgallifrey.teleportmod.Init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TeleportModMain.MOD_ID)
public class TeleportModMain {
    public static final String MOD_ID = "teleportmod";

    public TeleportModMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ItemInit.ITEMS.register(modEventBus);

        EnchantmentInit.ENCHANTMENTS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    //call setup method with param of
    //event of type FMLCommonSetupEvent
    private void setup(final FMLCommonSetupEvent event) {

    }
}
