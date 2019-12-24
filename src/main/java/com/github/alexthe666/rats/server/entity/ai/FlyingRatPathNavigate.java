package com.github.alexthe666.rats.server.entity.ai;

import com.github.alexthe666.rats.server.entity.EntityRat;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlyingRatPathNavigate extends FlyingPathNavigator {

    public EntityRat rat;

    public FlyingRatPathNavigate(EntityRat entityIn, World worldIn) {
        super(entityIn, worldIn);
        rat = entityIn;
    }

    public boolean tryMoveToLivingEntity(Entity entityIn, double speedIn) {
        if (rat.hasFlight()) {
            rat.getMoveHelper().setMoveTo(entityIn.posX, entityIn.posY + entityIn.getHeight(), entityIn.posZ, 0.25D);
        }
        Path path = this.getPathToLivingEntity(entityIn, 0);
        return path != null && this.setPath(path, speedIn);
    }

    public boolean tryMoveToXYZ(double x, double y, double z, double speedIn) {
        if (rat.hasFlight()) {
            rat.getMoveHelper().setMoveTo(x, y, z, 0.25D);
        }
        return this.setPath(getPathToPos(new BlockPos(x, y, z), 0), speedIn);
    }
}
