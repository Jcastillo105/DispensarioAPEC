package com.dispensario.converter;

import com.dispensario.jc.TiposFarmacos;
import com.dispensario.facade.TiposFarmacosFacade;
import com.dispensario.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "tiposFarmacosConverter")
public class TiposFarmacosConverter implements Converter {

    private TiposFarmacosFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof TiposFarmacos) {
            TiposFarmacos o = (TiposFarmacos) object;
            return getStringKey(o.getIdTipoFarmaco());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TiposFarmacos.class.getName()});
            return null;
        }
    }

    private TiposFarmacosFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(TiposFarmacosFacade.class).get();
        return this.ejbFacade;
    }
}
