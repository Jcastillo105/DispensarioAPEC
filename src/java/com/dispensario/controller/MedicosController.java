package com.dispensario.controller;

import com.dispensario.jc.Medicos;
import com.dispensario.jc.RegistroVisitas;
import java.util.Collection;
import com.dispensario.facade.MedicosFacade;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "medicosController")
@ViewScoped
public class MedicosController extends AbstractController<Medicos> {

    // Flags to indicate if child collections are empty
    private boolean isRegistroVisitasCollectionEmpty;

    public MedicosController() {
        // Inform the Abstract parent controller of the concrete Medicos Entity
        super(Medicos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRegistroVisitasCollectionEmpty();
    }

    public boolean getIsRegistroVisitasCollectionEmpty() {
        return this.isRegistroVisitasCollectionEmpty;
    }

    private void setIsRegistroVisitasCollectionEmpty() {
        Medicos selected = this.getSelected();
        if (selected != null) {
            MedicosFacade ejbFacade = (MedicosFacade) this.getFacade();
            this.isRegistroVisitasCollectionEmpty = ejbFacade.isRegistroVisitasCollectionEmpty(selected);
        } else {
            this.isRegistroVisitasCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of RegistroVisitas entities
     * that are retrieved from Medicos and returns the navigation outcome.
     *
     * @return navigation outcome for RegistroVisitas page
     */
    public String navigateRegistroVisitasCollection() {
        Medicos selected = this.getSelected();
        if (selected != null) {
            MedicosFacade ejbFacade = (MedicosFacade) this.getFacade();
            Collection<RegistroVisitas> selectedRegistroVisitasCollection = ejbFacade.findRegistroVisitasCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RegistroVisitas_items", selectedRegistroVisitasCollection);
        }
        return "/app/registroVisitas/index";
    }

     private String cedula;

    // Validador de Cedula

    public void validarCedula() {
        if (!CedulaValidator.validaCedula(cedula)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cédula inválida", "Por favor, ingrese una cédula válida."));
        } else {
            // Proceder con la lógica de negocio si la cédula es válida
        }
    }
    
}
