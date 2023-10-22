package com.tardisgallifrey.teleportmod.Init;

import com.tardisgallifrey.teleportmod.TeleportModMain;
import com.tardisgallifrey.teleportmod.items.TeleportStaff;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

//This is the Item Init(ialization) class
//There can be one for Blocks and
// ones for other Entities

public class ItemInit {

    //no constructor in this class


    //This registers our ITEMS, deferred
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    TeleportModMain.MOD_ID);


    //This registers our TELEPORT_STAFF object to ITEMS
    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("teleport_staff",
            () -> new TeleportStaff(new Item.Properties()
                    .tab(ModCreativeTab.instance)
                    .durability(100)));

    //This creates a Creative Mode Tab for items
    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(TELEPORT_STAFF.get());
        }

        //This creates an instance of the above
        //creative mode tab
        public static final ModCreativeTab instance =
                new ModCreativeTab(CreativeModeTab
                        .TABS.length, "teleportmod");
    }
}
