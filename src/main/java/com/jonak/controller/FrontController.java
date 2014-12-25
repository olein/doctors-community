package com.jonak.controller;

import com.jonak.lib.SessionLib;
import com.jonak.model.Category;
import com.jonak.model.Content;
import com.jonak.model.Search;

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
        Vector healthtips = Search.getHealthTips();
        this.dataOut.add( healthtips );

        return this.SUCCESS;
    }
}
