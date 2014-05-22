package biomesoplenty.common.biomes.overworld.sub;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.biomes.BOPSubBiome;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import biomesoplenty.common.world.features.trees.WorldGenBOPShrub;
import biomesoplenty.common.world.features.trees.WorldGenPineTree;

public class BiomeGenCanyonRavine extends BOPSubBiome
{
	private static final Height biomeHeight = new Height(-0.1F, 0.4F);

	public BiomeGenCanyonRavine(int id)
	{
		super(id);
		
		this.zoom = 0.25D;
		this.threshold = 0.25D;
		
        //TODO: setHeight()
        this.setHeight(biomeHeight);
        //TODO:	setColor()
        this.setColor(9337689);
        this.setTemperatureRainfall(0.8F, 0.4F);

		this.spawnableCreatureList.clear();

		this.topBlock = BOPBlockHelper.get("hardDirt");
		this.fillerBlock = BOPBlockHelper.get("hardDirt");
		this.theBiomeDecorator.grassPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.flowersPerChunk = -999;

        this.bopWorldFeatures.setFeature("bromeliadsPerChunk", 3);
        this.bopWorldFeatures.setFeature("grassSplatterPerChunk", 4);
        this.bopWorldFeatures.setFeature("waterReedsPerChunk", 4);
        this.bopWorldFeatures.setFeature("generatePumpkins", false);

        this.bopWorldFeatures.setFeature("bopGrassPerChunk", 5);

        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("foliage"), 2), 1D);
	}

	@Override
	//TODO:						getRandomWorldGenForTrees()
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return random.nextInt(5) == 0 ? new WorldGenPineTree() : new WorldGenBOPShrub(Blocks.log2, Blocks.leaves2, 0, 0, 64, 256, BOPBlockHelper.get("hardDirt"));
	}
	
	@Override
	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		super.decorate(world, random, chunkX, chunkZ);
		int var5 = 12 + random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(28) + 4;
			int z = chunkZ + random.nextInt(16);

			Block block = world.getBlock(x, y, z);

			if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
			{
				world.setBlock(x, y, z, BOPBlockHelper.get("gemOre"), 2, 2);
			}
		}
	}

	@Override
	//TODO:		getBiomeFoliageColor()
	public int getBiomeFoliageColor(int x, int y, int z)
	{
		return 11123300;
	}

	@Override
	//TODO:		getBiomeGrassColor()
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
		
		return 11123300;
	}
}
