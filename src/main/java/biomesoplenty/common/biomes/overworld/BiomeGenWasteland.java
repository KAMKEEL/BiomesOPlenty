package biomesoplenty.common.biomes.overworld;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.biomes.BOPBiome;
import biomesoplenty.common.configuration.BOPConfigurationMisc;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import biomesoplenty.common.world.features.trees.WorldGenDeadTree;

public class BiomeGenWasteland extends BOPBiome
{
    private static final Height biomeHeight = new Height(0.1F, 0.1F);

    public BiomeGenWasteland(int id)
    {
        super(id);

        this.setHeight(biomeHeight);
        this.setDisableRain();
        this.setColor(5919808);
        this.setTemperatureRainfall(2.0F, 0.05F);
        
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        
        this.waterColorMultiplier = 15073024;
        
        this.topBlock = BOPBlockHelper.get("driedDirt");
        this.fillerBlock = BOPBlockHelper.get("driedDirt");
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 20;
        
        this.bopWorldFeatures.setFeature("poisonLakesPerChunk", 10);
        this.bopWorldFeatures.setFeature("waterLakesPerChunk", 2);
        this.bopWorldFeatures.setFeature("wasteland1PerChunk", 1);
        this.bopWorldFeatures.setFeature("wasteland2PerChunk", 1);
        this.bopWorldFeatures.setFeature("wasteland3PerChunk", 1);
        this.bopWorldFeatures.setFeature("wasteland4PerChunk", 1);
        this.bopWorldFeatures.setFeature("wastelandRockPilesPerChunk", 2);

        this.bopWorldFeatures.setFeature("bopGrassPerChunk", 20);

        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPBlockHelper.get("plants"), 0), 1D);
    }

    @Override
    //TODO:                     getRandomWorldGenForTrees()
    public WorldGenAbstractTree func_150567_a(Random random)
    {
        return new WorldGenDeadTree();
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
                world.setBlock(x, y, z, BOPBlockHelper.get("gemOre"), 10, 2);
            }
        }
	}

    @Override
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        return 10330232;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 10067541;
    }
    
    @Override
    public int getSkyColorByTemp(float par1)
    {
        if (BOPConfigurationMisc.skyColors) return 9477744;
        else return super.getSkyColorByTemp(par1);
    }

    /*@Override
    public int getFogColour()
    {
        return 12106885;
    }
    */

    /*@Override
    public float getFogCloseness()
    {
        // TODO Auto-generated method stub
        return 0.3F;
    }
    */
}
