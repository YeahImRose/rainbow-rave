/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.rainbowrave;

import java.awt.Color;
import java.time.Duration;
import java.time.Instant;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import static net.runelite.api.TileItem.OWNERSHIP_OTHER;
import net.runelite.api.coords.WorldPoint;

@Data
@Builder
class GroundItem
{
	private int id;
	private int itemId;
	private String name;
	private int quantity;
	private WorldPoint location;
	private int height;
	private int haPrice;
	private int gePrice;
	private int offset;
	private boolean tradeable;
	private int ownership;
	private boolean isPrivate;
	@Nullable
	private Instant spawnTime;
	private boolean stackable;
	private Duration despawnTime;
	private Duration visibleTime;

	// cached values derived from config
	boolean highlighted;
	boolean hidden;
	Color color;

	int getHaPrice()
	{
		return haPrice * quantity;
	}

	int getGePrice()
	{
		return gePrice * quantity;
	}

	boolean isMine()
	{
		return ownership != OWNERSHIP_OTHER;
	}

	void reset()
	{
		highlighted = hidden = false;
		color = null;
	}
}
