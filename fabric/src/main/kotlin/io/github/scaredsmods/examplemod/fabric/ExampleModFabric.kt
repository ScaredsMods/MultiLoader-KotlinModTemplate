package io.github.scaredsmods.examplemod.fabric;

import net.fabricmc.api.ModInitializer;

import io.github.scaredsmods.examplemod.ExampleMod;

class ExampleModFabric : ModInitializer {

    override fun onInitialize() {
        ExampleMod.init();
    }
}
