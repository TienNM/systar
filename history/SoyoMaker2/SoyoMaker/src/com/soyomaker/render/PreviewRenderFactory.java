/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soyomaker.render;

import com.soyomaker.model.map.Map;

/**
 *
 * @author Administrator
 */
public class PreviewRenderFactory {
     /**
     * 先检查有没有以插件扩展的地图view，没有则默认用orthomapview
     * @param map 
     * @return
     */
    public static PreviewRender createPreviewRender(Map map) {
        return new OrthoPreviewRender(map);
    }
}
