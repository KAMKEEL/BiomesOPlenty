/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.common.world.gen.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class LushSavannaSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration>
{
    public LushSavannaSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> deserializer)
    {
        super(deserializer);
    }

    @Override
    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int startY, long seed, SurfaceBuilderBaseConfiguration config)
    {
        if (noise > 2.1D)
        {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, startY, seed, SurfaceBuilder.CONFIG_COARSE_DIRT);
        }
        else
        {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, startY, seed, SurfaceBuilder.CONFIG_GRASS);
        }
    }
}