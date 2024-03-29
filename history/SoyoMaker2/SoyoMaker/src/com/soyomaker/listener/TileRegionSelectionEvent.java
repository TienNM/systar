/*
 * Copyright 2010-2011 Soyostar Software, Inc. All rights reserved.
 */
package com.soyomaker.listener;

import com.soyomaker.model.map.TileLayer;
import java.util.EventObject;

/**
 * An event that describes the selection of a tile region.
 *
 * @version $Id$
 */
public class TileRegionSelectionEvent extends EventObject
{
    private final TileLayer tileLayer;

    /**
     *
     * @param source
     * @param tileLayer
     */
    public TileRegionSelectionEvent(Object source, TileLayer tileLayer) {
        super(source);
        this.tileLayer = tileLayer;
    }

    /**
     *
     * @return
     */
    public TileLayer getTileRegion() {
        return tileLayer;
    }
}