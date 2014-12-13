package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.model.Category;
import com.jonak.model.Content;

import java.util.Vector;

/**
 * Created by lenin on 12/13/14.
 */
public class FrontController extends BaseController {

    public String index() throws Exception
    {
        // 0'th index has category list
        this.dataOut.add(Category.findCategory());

        // 1'th index has health tips
        Vector healthtips = Content.findByType(6);
        int size = healthtips.size();
        while( size > 3 ) {
            size--;
            healthtips.remove(size);
        }
        this.dataOut.add( healthtips );

        return this.SUCCESS;
    }
}
