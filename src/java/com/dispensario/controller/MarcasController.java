package com.dispensario.controller;

import com.dispensario.jc.Marcas;
import com.dispensario.jc.Medicamentos;
import java.util.Collection;
import com.dispensario.facade.MarcasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "marcasController")
@ViewScoped
public class MarcasController extends AbstractController<Marcas> {

    // Flags to indicate if child collections are empty
    private boolean isMedicamentosCollectionEmpty;

    public MarcasController() {
        // Inform the Abstract parent controller of the concrete Marcas Entity
        super(Marcas.class);
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
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            this.isMedicamentosCollectionEmpty = ejbFacade.isMedicamentosCollectionEmpty(selected);
        } else {
            this.isMedicamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Medicamentos entities
     * that are retrieved from Marcas and returns the navigation outcome.
     *
     * @return navigation outcome for Medicamentos page
     */
    public String navigateMedicamentosCollection() {
        Marcas selected = this.getSelected();
        if (selected != null) {
            MarcasFacade ejbFacade = (MarcasFacade) this.getFacade();
            Collection<Medicamentos> selectedMedicamentosCollection = ejbFacade.findMedicamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Medicamentos_items", selectedMedicamentosCollection);
        }
        return "/app/medicamentos/index";
    }

}
