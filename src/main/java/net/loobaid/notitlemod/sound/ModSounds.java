package net.loobaid.notitlemod.sound;

import net.loobaid.notitlemod.NoTitleMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent GIGACHAD_SONG = registerSoundEvents("gigachad_song");
    public static final RegistryKey<JukeboxSong> GIGACHAD_SONG_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(NoTitleMod.MOD_ID, "gigachad_song"));

    private static SoundEvent registerSoundEvents(String name) {
        Identifier id = Identifier.of(NoTitleMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        NoTitleMod.LOGGER.info("Registering sounds!");
    }
}
