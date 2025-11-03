package io.github.scaredsmods.examplemod.neoforge;

import net.neoforged.fml.common.Mod;

import io.github.scaredsmods.examplemod.ExampleMod;
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

@Mod(ExampleMod.MOD_ID)
class ExampleModNeoForge(eventBus: IEventBus) {

    companion object {
    }

    init {
        ExampleMod.init()
    }

}
