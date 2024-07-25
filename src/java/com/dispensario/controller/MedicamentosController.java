package com.dispensario.controller;

import com.dispensario.jc.Medicamentos;
import com.dispensario.facade.MedicamentosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "medicamentosController")
@ViewScoped
public class MedicamentosController extends AbstractController<Medicamentos> {

    @Inject
    private MarcasController idMarcaController;
    @Inject
    private TiposFarmacosController idTipoFarmacoController;
    @Inject
    private UbicacionesController idUbicacionController;

    public MedicamentosController() {
        // Inform the Abstract parent controller of the concrete Medicamentos Entity
        super(Medicamentos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMarcaController.setSelected(null);
        idTipoFarmacoController.setSelected(null);
        idUbicacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Marcas controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMarca(ActionEvent event) {
        Medicamentos selected = this.getSelected();
        if (selected != null && idMarcaController.getSelected() == null) {
            idMarcaController.setSelected(selected.getIdMarca());
        }
    }

    /**
     * Sets the "selected" attribute of the TiposFarmacos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTipoFarmaco(ActionEvent event) {
        Medicamentos selected = this.getSelected();
        if (selected != null && idTipoFarmacoController.getSelected() == null) {
            idTipoFarmacoController.setSelected(selected.getIdTipoFarmaco());
        }
    }

    /**
     * Sets the "selected" attribute of the Ubicaciones controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdUbicacion(ActionEvent event) {
        Medicamentos selected = this.getSelected();
        if (selected != null && idUbicacionController.getSelected() == null) {
            idUbicacionController.setSelected(selected.getIdUbicacion());
        }
    }

}
