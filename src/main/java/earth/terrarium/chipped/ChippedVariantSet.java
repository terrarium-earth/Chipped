package earth.terrarium.chipped;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.codecs.EnumCodec;

import java.util.List;

public record ChippedVariantSet(ChippedBlockTypes type, List<String> variants) {
    public static final Codec<ChippedVariantSet> BASE_CODEC = RecordCodecBuilder.create(instance -> instance.group(
        EnumCodec.of(ChippedBlockTypes.class).fieldOf("type").forGetter(ChippedVariantSet::type),
        Codec.list(Codec.STRING).fieldOf("variants").forGetter(ChippedVariantSet::variants)
    ).apply(instance, ChippedVariantSet::new));

    public static final Codec<ChippedVariantSet> CODEC = Codec.either(Codec.STRING.listOf(), BASE_CODEC).xmap(
        either -> either.map(variants -> new ChippedVariantSet(ChippedBlockTypes.BLOCK, variants), v -> v),
        set -> Either.left(set.variants)
    );

    public ChippedVariantSet(List<String> variants) {
        this(ChippedBlockTypes.BLOCK, variants);
    }
}
