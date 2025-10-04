package com.compactrunepouch;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CompactRunepouchPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CompactRunepouchPlugin.class);
		RuneLite.main(args);
	}
}