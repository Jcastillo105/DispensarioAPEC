package com.dispensario.controller;

import com.dispensario.jc.Ubicaciones;
import com.dispensario.jc.Medicamentos;
import java.util.Collection;
import com.dispensario.facade.UbicacionesFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ubicacionesController")
@ViewScoped
public class UbicacionesController extends AbstractController<Ubicaciones> {

    // Flags to indicate if child collections are empty
    private boolean isMedicamentosCollectionEmpty;

    public UbicacionesController() {
        // Inform the Abstract parent controller of the concrete Ubicaciones Entity
        super(Ubicaciones.class);
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
        Ubicaciones selected = this.getSelected();
        if (selected != null) {
            UbicacionesFacade ejbFacade = (UbicacionesFacade) this.getFacade();
            this.isMedicamentosCollectionEmpty = ejbFacade.isMedicamentosCollectionEmpty(selected);
        } else {
            this.isMedicamentosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Medicamentos entities
     * that are retrieved from Ubicaciones and returns the navigation outcome.
     *
     * @return navigation outcome for Medicamentos page
     */
    public String navigateMedicamentosCollection() {
        Ubicaciones selected = this.getSelected();
        if (selected != null) {
            UbicacionesFacade ejbFacade = (UbicacionesFacade) this.getFacade();
            Collection<Medicamentos> selectedMedicamentosCollection = ejbFacade.findMedicamentosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Medicamentos_items", selectedMedicamentosCollection);
        }
        return "/app/medicamentos/index";
    }

}
