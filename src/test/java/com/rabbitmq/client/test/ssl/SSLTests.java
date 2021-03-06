//  The contents of this file are subject to the Mozilla Public License
//  Version 1.1 (the "License"); you may not use this file except in
//  compliance with the License. You may obtain a copy of the License
//  at http://www.mozilla.org/MPL/
//
//  Software distributed under the License is distributed on an "AS IS"
//  basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
//  the License for the specific language governing rights and
//  limitations under the License.
//
//  The Original Code is RabbitMQ.
//
//  The Initial Developer of the Original Code is GoPivotal, Inc.
//  Copyright (c) 2007-2016 Pivotal Software, Inc.  All rights reserved.
//


package com.rabbitmq.client.test.ssl;

import junit.framework.TestSuite;

import com.rabbitmq.client.test.AbstractRMQTestSuite;

public class SSLTests extends AbstractRMQTestSuite {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("ssl");
        //Skip the tests if not under umbrella and not SSL available
        if (!requiredProperties()) return suite;
        if (!(isUnderUmbrella() && isSSLAvailable())) return suite;
        suite.addTestSuite(UnverifiedConnection.class);
        suite.addTestSuite(VerifiedConnection.class);
        suite.addTestSuite(BadVerifiedConnection.class);
        return suite;
    }
}
