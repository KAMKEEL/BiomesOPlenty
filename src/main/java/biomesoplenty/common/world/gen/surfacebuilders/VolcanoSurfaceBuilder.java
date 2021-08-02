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

public class VolcanoSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration>
{
	public VolcanoSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> deserializer)
	{
		super(deserializer);
	}

	@Override
	public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int startY, long seed, SurfaceBuilderBaseConfiguration config)
	{
		if (noise > 2.7F)
		{
			SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, startY, seed, BOPSurfaceBuilders.MAGMA_SURFACE);
		}
		else
		{
			BOPSurfaceBuilders.DEEP_TOP_LAYER.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, startY, seed, BOPSurfaceBuilders.BASALT_SURFACE);
		}
	}
}