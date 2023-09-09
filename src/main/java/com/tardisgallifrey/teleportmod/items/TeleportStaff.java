package com.tardisgallifrey.teleportmod.items;

//import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class TeleportStaff extends Item {

    public TeleportStaff(Properties properties){
        super(properties);
    }//end constructor

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player player, @NotNull InteractionHand hand){
        //This is the place or block a player is looking at,
        //plus a distance to move forward (not sure if it's in blocks)
        BlockHitResult ray = rayTrace(world, player, 50.0d);


        //translates the ray's result to a block position
        //BlockPos lookPos = ray.getBlockPos();
        //above method call allows one to go into blocks below, get stuck
        //below method call one can only go forward.  Can't go into blocks
        BlockPos lookPos = ray.getBlockPos().relative(ray.getDirection());

        //Moves the player to that position
        player.setPos(lookPos.getX(), lookPos.getY(), lookPos.getZ());

        // play a teleport sound. the last two args are volume and pitch
        world.playSound(player, player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.PLAYERS,
                1.0F,
                1.0F);

        //Can't do it willy-nilly
        player.getCooldowns().addCooldown(this, 120);

        //Removes fall damage from dropping back down
        player.fallDistance = 0F;

        //returns the player's new location, hand, etc. to the world?
        return super.use(world, player, hand);
    }//end InteractionResultHolder

    //modified BlockHitResult that allows extra teleport distance
    protected static @NotNull BlockHitResult rayTrace(@NotNull Level world, @NotNull Player player, double range) {
        //Our alteration to the default formula
        //double range = 15;

        //Default Hit result formula from Minecraft Vanilla Item (5 blocks)
        float f = player.getXRot();
        float f1 = player.getYRot();

        //Gets the player eye position in an OpenGL (GLSL) Vec3
        Vec3 vector3d = player.getEyePosition(1.0F);

        //do the math
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;

        //multiplying each Vec3 value by range means longer teleports
        Vec3 vector3d1 = vector3d.add((double)f6 * range,
                (double)f5 * range,
                (double)f7 * range);

        //return new teleporting location??
        //or distance from player to new location??
        return world.clip(new ClipContext(vector3d,
                vector3d1,
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                player));
    }//end rayTrace()
}
