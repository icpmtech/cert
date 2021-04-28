/*
 * $Id: ModuleServiceEJB.java,v 1.3 2009/06/22 13:58:03 pjfsilva Exp $
 *
 * Copyright (c) Critical Software S.A., All Rights Reserved.
 * (www.criticalsoftware.com)
 *
 * This software is the proprietary information of Critical Software S.A.
 * Use is subject to license terms.
 *
 * Last changed on : $Date: 2009/06/22 13:58:03 $
 * Last changed by : $Author: pjfsilva $
 */
package com.criticalsoftware.certitools.business.certitools;

import com.criticalsoftware.certitools.entities.Module;
import com.criticalsoftware.certitools.persistence.certitools.ModuleDAO;
import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.security.SecurityDomain;

import javax.annotation.security.RunAs;
import javax.ejb.*;
import java.util.Collection;

/**
 * Module Service Implementation
 *
 * @author jp-gomes
 */

@Stateless
@Local(ModuleService.class)
@LocalBinding(jndiBinding = "java:/app/certitools/ModuleService")
@SecurityDomain("CertiToolsRealm")
@RunAs("private")
public class ModuleServiceEJB implements ModuleService {

    @EJB
    private ModuleDAO moduleDAO;

    @TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public Collection<Module> findAll() {
        return moduleDAO.findAll();
    }
}
