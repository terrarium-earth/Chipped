package com.grimbo.chipped.data.client;

import com.grimbo.chipped.Chipped;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.grimbo.chipped.block.ChippedBlockTypes.*;

public class ChippedLanguageProvider extends LanguageProvider {

    public ChippedLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Chipped.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {

    }
}
