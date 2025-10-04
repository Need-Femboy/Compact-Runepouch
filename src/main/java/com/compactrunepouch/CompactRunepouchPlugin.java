package com.compactrunepouch;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
		name = "Compact Runepouch",
		description = "Removes the preset label from the rune pouch interface",
		tags = {"qol"}
)
public class CompactRunepouchPlugin extends Plugin
{
	@Inject
	private Client client;
	
	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event) {
		if (event.getGroupId() != InterfaceID.BANKSIDE) {
			return;
		}
		
		Widget loadoutParent = client.getWidget(InterfaceID.Bankside.RUNEPOUCH_LOADOUT_CONTAINER);
		
		int newY = -25;
		
		if (loadoutParent != null) {
			for (Widget loadout : loadoutParent.getStaticChildren()) {
				//Original 4 widgets have the name widget be the second static child, the new ones have it be the first one for some reason.
				Widget actualNameWidget = loadout.getStaticChildren()[1].getOriginalHeight() == 18 ? loadout.getStaticChildren()[1] : loadout.getStaticChildren()[0];
				actualNameWidget.setHidden(true);
				loadout.setOriginalY(newY);
				loadout.revalidate();
				newY += 35;
			}
		}
		
	}
}
