package com.dispensario.controller;

import com.dispensario.jc.TiposFarmacos;
import com.dispensario.jc.Medicamentos;
import java.util.Collection;
import com.dispensario.facade.TiposFarmacosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposFarmacosController")
@ViewScoped
public class TiposFarmacosController extends AbstractController<TiposFarmacos> {

    // Flags to indicate if child collections are empty
    private boolean isMedicamentosCollectionEmpty;

    public TiposFarmacosController() {
        // Inform the Abstract parent controller of the concrete TiposFarmacos Entity
        super(TiposFarmacos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsMedicamentosCollectionEmpty();
    }

    public boolean getIsMedicamentosCollectionEmpty() {
        return this.isMedicamentosCollectionEmpty;
    }

    private void setIsMedicamentosCollectionEmpty() {
        TiposFarmacos selected = this.getSelected();
        if (selected != null) {
            TiposFarmacosFacade ejbFacade = (TiposFarmacosFacade) this.getFacade();
            this.isMedicamentosCollectionEmpty = ejbFacade.isMedicamentosCollectionEmpty(selected);
        } else {
            this.isMedicamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Medicamentos entities
     * that are retrieved from TiposFarmacos and returns the navigation outcome.
     *
     * @return navigation outcome for Medicamentos page
     */
    public String navigateMedicamentosCollection() {
        TiposFarmacos selected = this.getSelected();
        if (selected != null) {
            TiposFarmacosFacade ejbFacade = (TiposFarmacosFacade) this.getFacade();
            Collection<Medicamentos> selectedMedicamentosCollection = ejbFacade.findMedicamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Medicamentos_items", selectedMedicamentosCollection);
        }
        return "/app/medicamentos/index";
    }

}
