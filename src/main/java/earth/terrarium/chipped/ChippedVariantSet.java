package earth.terrarium.chipped;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.resourcefullib.common.codecs.EnumCodec;

import java.util.Map;

public record ChippedVariantSet(Map<String, ChippedBlockType> variants) {
    public static final Codec<ChippedVariantSet> CODEC = Codec.unboundedMap(Codec.STRING, EnumCodec.of(ChippedBlockType.class)).xmap(ChippedVariantSet::new, ChippedVariantSet::variants);
}
