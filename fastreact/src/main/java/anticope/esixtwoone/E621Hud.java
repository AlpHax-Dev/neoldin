package anticope.fastreact;

import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;

import meteordevelopment.meteorclient.systems.hud.Hud;
import org.slf4j.Logger;

import net.fabricmc.loader.api.FabricLoader;

public class fastreact extends MeteorAddon {
	public static final Logger LOG = LogUtils.getLogger();

	@Override
	public void onInitialize() {
		LOG.info("Initializing fastreact");

		// HUD
        Hud hud = Hud.get();
        hud.register(ImageHUD.INFO);
	}

    @Override
    public String getPackage() {
        return "anticope.fastreact";
    }

    @Override
    public String getWebsite() {
        return "https://github.com/AntiCope/meteor-e621-integration";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("AntiCope", "meteor-e621-integration");
    }

    @Override
    public String getCommit() {
        String commit = FabricLoader
            .getInstance()
            .getModContainer(fastreact")
            .get().getMetadata()
            .getCustomValue("github:sha")
            .getAsString();
        return commit.isEmpty() ? null : commit.trim();

    }
}
