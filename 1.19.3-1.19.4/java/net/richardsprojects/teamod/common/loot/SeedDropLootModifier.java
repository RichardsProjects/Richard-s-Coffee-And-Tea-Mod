package net.richardsprojects.teamod.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.richardsprojects.teamod.CoffeeAndTeaMod;

import java.util.function.Supplier;

public class SeedDropLootModifier extends LootModifier {

    public static final Supplier<Codec<SeedDropLootModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst).apply(inst, SeedDropLootModifier::new))
    );

    protected SeedDropLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextInt(2) == 1) {
            generatedLoot.add(new ItemStack(CoffeeAndTeaMod.TEA_SEED.get()));
        } else {
            generatedLoot.add(new ItemStack(CoffeeAndTeaMod.UNROASTED_COFFEE_BEAN.get()));
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}