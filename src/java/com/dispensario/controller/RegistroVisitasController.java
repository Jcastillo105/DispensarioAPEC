package com.dispensario.controller;

import com.dispensario.jc.RegistroVisitas;
import com.dispensario.facade.RegistroVisitasFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroVisitasController")
@ViewScoped
public class RegistroVisitasController extends AbstractController<RegistroVisitas> {

    @Inject
    private MedicosController idMedicoController;
    @Inject
    private PacientesController idPacienteController;

    public RegistroVisitasController() {
        // Inform the Abstract parent controller of the concrete RegistroVisitas Entity
        super(RegistroVisitas.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMedicoController.setSelected(null);
        idPacienteController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Medicos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMedico(ActionEvent event) {
        RegistroVisitas selected = this.getSelected();
        if (selected != null && idMedicoController.getSelected() == null) {
            idMedicoController.setSelected(selected.getIdMedico());
        }
    }

    /**
     * Sets the "selected" attribute of the Pacientes controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdPaciente(ActionEvent event) {
        RegistroVisitas selected = this.getSelected();
        if (selected != null && idPacienteController.getSelected() == null) {
            idPacienteController.setSelected(selected.getIdPaciente());
        }
    }

}
