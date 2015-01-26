//package com.giftedpineapples.wood.block;
//
//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.init.Blocks;
//import net.minecraft.init.Items;
//import net.minecraft.item.Item;
//import net.minecraft.util.AxisAlignedBB;
//import net.minecraft.util.Direction;
//import net.minecraft.util.IIcon;
//import net.minecraft.world.ChunkPosition;
//import net.minecraft.world.IBlockAccess;
//import net.minecraft.world.World;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Random;
//import java.util.Set;
//
//public class BlockRedstoneWire extends Block
//{
//	private boolean canProvidePower = true;
//	private Set chunkPositions = new HashSet();
//	@SideOnly(Side.CLIENT)
//	private IIcon icon_1;
//	@SideOnly(Side.CLIENT)
//	private IIcon icon_2;
//	@SideOnly(Side.CLIENT)
//	private IIcon icon_3;
//	@SideOnly(Side.CLIENT)
//	private IIcon icon_4;
//	private static final String __OBFID = "CL_00000295";
//
//	public BlockRedstoneWire()
//	{
//		super(Material.circuits);
//		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
//	}
//
//	/**
//	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
//	 * cleared to be reused)
//	 */
//	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
//	{
//		return null;
//	}
//
//	/**
//	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
//	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
//	 */
//	public boolean isOpaqueCube()
//	{
//		return false;
//	}
//
//	/**
//	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
//	 */
//	public boolean renderAsNormalBlock()
//	{
//		return false;
//	}
//
//	/**
//	 * The type of render function that is called for this block
//	 */
//	public int getRenderType()
//	{
//		return 5;
//	}
//
//	/**
//	 * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
//	 * when first determining what to render.
//	 */
//	@SideOnly(Side.CLIENT)
//	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
//	{
//		return 8388608;
//	}
//
//	/**
//	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
//	 */
//	public boolean canPlaceBlockAt(World world, int x, int y, int z)
//	{
//		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || world.getBlock(x, y - 1, z) == Blocks.glowstone;
//	}
//
//	private void func_150177_e(World world, int x, int y, int z)
//	{
//		this.func_150175_a(world, x, y, z, x, y, z);
//		ArrayList arraylist = new ArrayList(this.chunkPositions);
//		this.chunkPositions.clear();
//
//		for (int l = 0; l < arraylist.size(); ++l)
//		{
//			ChunkPosition chunkposition = (ChunkPosition)arraylist.get(l);
//			world.notifyBlocksOfNeighborChange(chunkposition.chunkPosX, chunkposition.chunkPosY, chunkposition.chunkPosZ, this);
//		}
//	}
//
//	private void func_150175_a(World world, int x1, int y1, int z1, int x2, int y2, int z2)
//	{
//		int thisPower = world.getBlockMetadata(x1, y1, z1);
//		byte initialPower = 0;
//		int power = this.getBlockPower(world, x2, y2, z2, initialPower);
//		this.canProvidePower = false;
//		int strongestIndirectPower = world.getStrongestIndirectPower(x1, y1, z1);
//		this.canProvidePower = true;
//
//		if (strongestIndirectPower > 0 && strongestIndirectPower > power - 1)
//		{
//			power = strongestIndirectPower;
//		}
//
//		int currentPower = 0;
//
//		for (int i = 0; i < 4; ++i)
//		{
//			int x = x1;
//			int z = z1;
//
//			if (i == 0)
//			{
//				x = x1 - 1;
//			}
//
//			if (i == 1)
//			{
//				++x;
//			}
//
//			if (i == 2)
//			{
//				z = z1 - 1;
//			}
//
//			if (i == 3)
//			{
//				++z;
//			}
//
//			if (x != x2 || z != z2)
//			{
//				currentPower = this.getBlockPower(world, x, y1, z, currentPower);
//			}
//
//			if (world.getBlock(x, y1, z).isNormalCube() && !world.getBlock(x1, y1 + 1, z1).isNormalCube())
//			{
//				if ((x != x2 || z != z2) && y1 >= y2)
//				{
//					currentPower = this.getBlockPower(world, x, y1 + 1, z, currentPower);
//				}
//			}
//			else if (!world.getBlock(x, y1, z).isNormalCube() && (x != x2 || z != z2) && y1 <= y2)
//			{
//				currentPower = this.getBlockPower(world, x, y1 - 1, z, currentPower);
//			}
//		}
//
//		if (currentPower > power)
//		{
//			power = currentPower - 1;
//		}
//		else if (power > 0)
//		{
//			--power;
//		}
//		else
//		{
//			power = 0;
//		}
//
//		if (strongestIndirectPower > power - 1)
//		{
//			power = strongestIndirectPower;
//		}
//
//		if (thisPower != power)
//		{
//			world.setBlockMetadataWithNotify(x1, y1, z1, power, 2);
//			this.chunkPositions.add(new ChunkPosition(x1, y1, z1));
//			this.chunkPositions.add(new ChunkPosition(x1 - 1, y1, z1));
//			this.chunkPositions.add(new ChunkPosition(x1 + 1, y1, z1));
//			this.chunkPositions.add(new ChunkPosition(x1, y1 - 1, z1));
//			this.chunkPositions.add(new ChunkPosition(x1, y1 + 1, z1));
//			this.chunkPositions.add(new ChunkPosition(x1, y1, z1 - 1));
//			this.chunkPositions.add(new ChunkPosition(x1, y1, z1 + 1));
//		}
//	}
//
//	private void func_150172_m(World p_150172_1_, int p_150172_2_, int p_150172_3_, int p_150172_4_)
//	{
//		if (p_150172_1_.getBlock(p_150172_2_, p_150172_3_, p_150172_4_) == this)
//		{
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_, p_150172_3_, p_150172_4_, this);
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_ - 1, p_150172_3_, p_150172_4_, this);
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_ + 1, p_150172_3_, p_150172_4_, this);
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_, p_150172_3_, p_150172_4_ - 1, this);
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_, p_150172_3_, p_150172_4_ + 1, this);
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_, p_150172_3_ - 1, p_150172_4_, this);
//			p_150172_1_.notifyBlocksOfNeighborChange(p_150172_2_, p_150172_3_ + 1, p_150172_4_, this);
//		}
//	}
//
//	/**
//	 * Called whenever the block is added into the world. Args: world, x, y, z
//	 */
//	public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
//	{
//		super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
//
//		if (!p_149726_1_.isRemote)
//		{
//			this.func_150177_e(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
//			p_149726_1_.notifyBlocksOfNeighborChange(p_149726_2_, p_149726_3_ + 1, p_149726_4_, this);
//			p_149726_1_.notifyBlocksOfNeighborChange(p_149726_2_, p_149726_3_ - 1, p_149726_4_, this);
//			this.func_150172_m(p_149726_1_, p_149726_2_ - 1, p_149726_3_, p_149726_4_);
//			this.func_150172_m(p_149726_1_, p_149726_2_ + 1, p_149726_3_, p_149726_4_);
//			this.func_150172_m(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ - 1);
//			this.func_150172_m(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_ + 1);
//
//			if (p_149726_1_.getBlock(p_149726_2_ - 1, p_149726_3_, p_149726_4_).isNormalCube())
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_ - 1, p_149726_3_ + 1, p_149726_4_);
//			}
//			else
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_ - 1, p_149726_3_ - 1, p_149726_4_);
//			}
//
//			if (p_149726_1_.getBlock(p_149726_2_ + 1, p_149726_3_, p_149726_4_).isNormalCube())
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_ + 1, p_149726_3_ + 1, p_149726_4_);
//			}
//			else
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_ + 1, p_149726_3_ - 1, p_149726_4_);
//			}
//
//			if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_ - 1).isNormalCube())
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_, p_149726_3_ + 1, p_149726_4_ - 1);
//			}
//			else
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_, p_149726_3_ - 1, p_149726_4_ - 1);
//			}
//
//			if (p_149726_1_.getBlock(p_149726_2_, p_149726_3_, p_149726_4_ + 1).isNormalCube())
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_, p_149726_3_ + 1, p_149726_4_ + 1);
//			}
//			else
//			{
//				this.func_150172_m(p_149726_1_, p_149726_2_, p_149726_3_ - 1, p_149726_4_ + 1);
//			}
//		}
//	}
//
//	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
//	{
//		super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
//
//		if (!p_149749_1_.isRemote)
//		{
//			p_149749_1_.notifyBlocksOfNeighborChange(p_149749_2_, p_149749_3_ + 1, p_149749_4_, this);
//			p_149749_1_.notifyBlocksOfNeighborChange(p_149749_2_, p_149749_3_ - 1, p_149749_4_, this);
//			p_149749_1_.notifyBlocksOfNeighborChange(p_149749_2_ + 1, p_149749_3_, p_149749_4_, this);
//			p_149749_1_.notifyBlocksOfNeighborChange(p_149749_2_ - 1, p_149749_3_, p_149749_4_, this);
//			p_149749_1_.notifyBlocksOfNeighborChange(p_149749_2_, p_149749_3_, p_149749_4_ + 1, this);
//			p_149749_1_.notifyBlocksOfNeighborChange(p_149749_2_, p_149749_3_, p_149749_4_ - 1, this);
//			this.func_150177_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
//			this.func_150172_m(p_149749_1_, p_149749_2_ - 1, p_149749_3_, p_149749_4_);
//			this.func_150172_m(p_149749_1_, p_149749_2_ + 1, p_149749_3_, p_149749_4_);
//			this.func_150172_m(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_ - 1);
//			this.func_150172_m(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_ + 1);
//
//			if (p_149749_1_.getBlock(p_149749_2_ - 1, p_149749_3_, p_149749_4_).isNormalCube())
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_ - 1, p_149749_3_ + 1, p_149749_4_);
//			}
//			else
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_ - 1, p_149749_3_ - 1, p_149749_4_);
//			}
//
//			if (p_149749_1_.getBlock(p_149749_2_ + 1, p_149749_3_, p_149749_4_).isNormalCube())
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_ + 1, p_149749_3_ + 1, p_149749_4_);
//			}
//			else
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_ + 1, p_149749_3_ - 1, p_149749_4_);
//			}
//
//			if (p_149749_1_.getBlock(p_149749_2_, p_149749_3_, p_149749_4_ - 1).isNormalCube())
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_, p_149749_3_ + 1, p_149749_4_ - 1);
//			}
//			else
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_, p_149749_3_ - 1, p_149749_4_ - 1);
//			}
//
//			if (p_149749_1_.getBlock(p_149749_2_, p_149749_3_, p_149749_4_ + 1).isNormalCube())
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_, p_149749_3_ + 1, p_149749_4_ + 1);
//			}
//			else
//			{
//				this.func_150172_m(p_149749_1_, p_149749_2_, p_149749_3_ - 1, p_149749_4_ + 1);
//			}
//		}
//	}
//
//	private int getBlockPower(World world, int x, int y, int z, int b)
//	{
//		if (world.getBlock(x, y, z) != this)
//		{
//			return b;
//		}
//		else
//		{
//			int blockMeta = world.getBlockMetadata(x, y, z);
//			return blockMeta > b ? blockMeta : b;
//		}
//	}
//
//	/**
//	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
//	 * their own) Args: x, y, z, neighbor Block
//	 */
//	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
//	{
//		if (!p_149695_1_.isRemote)
//		{
//			boolean flag = this.canPlaceBlockAt(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
//
//			if (flag)
//			{
//				this.func_150177_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
//			}
//			else
//			{
//				this.dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 0, 0);
//				p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
//			}
//
//			super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
//		}
//	}
//
//	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
//	{
//		return Items.redstone;
//	}
//
//	public int isProvidingStrongPower(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_)
//	{
//		return !this.canProvidePower ? 0 : this.isProvidingWeakPower(p_149748_1_, p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_);
//	}
//
//	public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
//	{
//		if (!this.canProvidePower)
//		{
//			return 0;
//		}
//		else
//		{
//			int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_, p_149709_4_);
//
//			if (i1 == 0)
//			{
//				return 0;
//			}
//			else if (p_149709_5_ == 1)
//			{
//				return i1;
//			}
//			else
//			{
//				boolean flag = func_150176_g(p_149709_1_, p_149709_2_ - 1, p_149709_3_, p_149709_4_, 1) || !p_149709_1_.getBlock(p_149709_2_ - 1, p_149709_3_, p_149709_4_).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_ - 1, p_149709_3_ - 1, p_149709_4_, -1);
//				boolean flag1 = func_150176_g(p_149709_1_, p_149709_2_ + 1, p_149709_3_, p_149709_4_, 3) || !p_149709_1_.getBlock(p_149709_2_ + 1, p_149709_3_, p_149709_4_).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_ + 1, p_149709_3_ - 1, p_149709_4_, -1);
//				boolean flag2 = func_150176_g(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_ - 1, 2) || !p_149709_1_.getBlock(p_149709_2_, p_149709_3_, p_149709_4_ - 1).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_, p_149709_3_ - 1, p_149709_4_ - 1, -1);
//				boolean flag3 = func_150176_g(p_149709_1_, p_149709_2_, p_149709_3_, p_149709_4_ + 1, 0) || !p_149709_1_.getBlock(p_149709_2_, p_149709_3_, p_149709_4_ + 1).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_, p_149709_3_ - 1, p_149709_4_ + 1, -1);
//
//				if (!p_149709_1_.getBlock(p_149709_2_, p_149709_3_ + 1, p_149709_4_).isNormalCube())
//				{
//					if (p_149709_1_.getBlock(p_149709_2_ - 1, p_149709_3_, p_149709_4_).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_ - 1, p_149709_3_ + 1, p_149709_4_, -1))
//					{
//						flag = true;
//					}
//
//					if (p_149709_1_.getBlock(p_149709_2_ + 1, p_149709_3_, p_149709_4_).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_ + 1, p_149709_3_ + 1, p_149709_4_, -1))
//					{
//						flag1 = true;
//					}
//
//					if (p_149709_1_.getBlock(p_149709_2_, p_149709_3_, p_149709_4_ - 1).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_, p_149709_3_ + 1, p_149709_4_ - 1, -1))
//					{
//						flag2 = true;
//					}
//
//					if (p_149709_1_.getBlock(p_149709_2_, p_149709_3_, p_149709_4_ + 1).isNormalCube() && func_150176_g(p_149709_1_, p_149709_2_, p_149709_3_ + 1, p_149709_4_ + 1, -1))
//					{
//						flag3 = true;
//					}
//				}
//
//				return !flag2 && !flag1 && !flag && !flag3 && p_149709_5_ >= 2 && p_149709_5_ <= 5 ? i1 : (p_149709_5_ == 2 && flag2 && !flag && !flag1 ? i1 : (p_149709_5_ == 3 && flag3 && !flag && !flag1 ? i1 : (p_149709_5_ == 4 && flag && !flag2 && !flag3 ? i1 : (p_149709_5_ == 5 && flag1 && !flag2 && !flag3 ? i1 : 0))));
//			}
//		}
//	}
//
//	/**
//	 * Can this block provide power. Only wire currently seems to have this change based on its state.
//	 */
//	public boolean canProvidePower()
//	{
//		return this.canProvidePower;
//	}
//
//	/**
//	 * Returns true if redstone wire can connect to the specified block. Params: World, X, Y, Z, side (not a normal
//	 * notch-side, this can be 0, 1, 2, 3 or -1)
//	 */
//	public static boolean isPowerProviderOrWire(IBlockAccess p_150174_0_, int p_150174_1_, int p_150174_2_, int p_150174_3_, int p_150174_4_)
//	{
//		Block block = p_150174_0_.getBlock(p_150174_1_, p_150174_2_, p_150174_3_);
//
//		if (block == Blocks.redstone_wire)
//		{
//			return true;
//		}
//		else if (!Blocks.unpowered_repeater.func_149907_e(block))
//		{
//			return block.canConnectRedstone(p_150174_0_, p_150174_1_, p_150174_2_, p_150174_3_, p_150174_4_);
//		}
//		else
//		{
//			int i1 = p_150174_0_.getBlockMetadata(p_150174_1_, p_150174_2_, p_150174_3_);
//			return p_150174_4_ == (i1 & 3) || p_150174_4_ == Direction.rotateOpposite[i1 & 3];
//		}
//	}
//
//	/**
//	 * A randomly called display update to be able to add particles or other items for display
//	 */
//	@SideOnly(Side.CLIENT)
//	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
//	{
//		int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_, p_149734_4_);
//
//		if (l > 0)
//		{
//			double d0 = (double)p_149734_2_ + 0.5D + ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
//			double d1 = (double)((float)p_149734_3_ + 0.0625F);
//			double d2 = (double)p_149734_4_ + 0.5D + ((double)p_149734_5_.nextFloat() - 0.5D) * 0.2D;
//			float f = (float)l / 15.0F;
//			float f1 = f * 0.6F + 0.4F;
//
//			if (l == 0)
//			{
//				f1 = 0.0F;
//			}
//
//			float f2 = f * f * 0.7F - 0.5F;
//			float f3 = f * f * 0.6F - 0.7F;
//
//			if (f2 < 0.0F)
//			{
//				f2 = 0.0F;
//			}
//
//			if (f3 < 0.0F)
//			{
//				f3 = 0.0F;
//			}
//
//			p_149734_1_.spawnParticle("reddust", d0, d1, d2, (double)f1, (double)f2, (double)f3);
//		}
//	}
//
//	public static boolean func_150176_g(IBlockAccess p_150176_0_, int p_150176_1_, int p_150176_2_, int p_150176_3_, int p_150176_4_)
//	{
//		if (isPowerProviderOrWire(p_150176_0_, p_150176_1_, p_150176_2_, p_150176_3_, p_150176_4_))
//		{
//			return true;
//		}
//		else if (p_150176_0_.getBlock(p_150176_1_, p_150176_2_, p_150176_3_) == Blocks.powered_repeater)
//		{
//			int i1 = p_150176_0_.getBlockMetadata(p_150176_1_, p_150176_2_, p_150176_3_);
//			return p_150176_4_ == (i1 & 3);
//		}
//		else
//		{
//			return false;
//		}
//	}
//
//	/**
//	 * Gets an item for the block being called on. Args: world, x, y, z
//	 */
//	@SideOnly(Side.CLIENT)
//	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
//	{
//		return Items.redstone;
//	}
//
//	@SideOnly(Side.CLIENT)
//	public void registerBlockIcons(IIconRegister p_149651_1_)
//	{
//		this.icon_1 = p_149651_1_.registerIcon(this.getTextureName() + "_" + "cross");
//		this.icon_2 = p_149651_1_.registerIcon(this.getTextureName() + "_" + "line");
//		this.icon_3 = p_149651_1_.registerIcon(this.getTextureName() + "_" + "cross_overlay");
//		this.icon_4 = p_149651_1_.registerIcon(this.getTextureName() + "_" + "line_overlay");
//		this.blockIcon = this.icon_1;
//	}
//
//	@SideOnly(Side.CLIENT)
//	public static IIcon getRedstoneWireIcon(String p_150173_0_)
//	{
//		return p_150173_0_.equals("cross") ? Blocks.redstone_wire.icon_1 : (p_150173_0_.equals("line") ? Blocks.redstone_wire.icon_2 : (p_150173_0_.equals("cross_overlay") ? Blocks.redstone_wire.icon_3 : (p_150173_0_.equals("line_overlay") ? Blocks.redstone_wire.icon_4 : null)));
//	}
//}