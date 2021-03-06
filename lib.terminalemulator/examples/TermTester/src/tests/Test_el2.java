/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package tests;

import termtester.Context;
import termtester.Test;
import termtester.Util;

/**
 * @author ivan
 */
public class Test_el2 extends Test {

    public Test_el2(Context context) {
        super("el2", context, 0, 0, false, Util.FillPattern.ZIGZAG);
    }

    private void el(int n) {
        context.send(String.format("\\ESC[%dK", n));
    }

    public void runBasic(String[] args) {

        // context.send("\\ESC[?5h");      // reverse video

        // Util.attr(context, 43);         // bg -> yellow
        // Util.attr(context, 4);          // underline

        int col = 9;
        col = 13;
        Util.attr(context, 43);         // bg -> yellow
        Util.attr(context, 4);          // underline

        Util.go(context, 3, col);
        el(0);          // to end

        Util.go(context, 4, col);
        el(1);          // to cursor

        Util.go(context, 5, col);     // whole line
        el(2);
    }
}
