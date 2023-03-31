package example.school.school.service;

import example.school.school.dto.FormDTO;
import example.school.school.dto.FormForListDTO;
import example.school.school.dto.RegionDTO;
import example.school.school.entity.FormEntity;
import example.school.school.entity.RegionEntity;
import example.school.school.exception.FormNotFoundException;
import example.school.school.exception.RegionAlreadyExistException;
import example.school.school.repository.FormRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormService {

    private FormRepo formRepo;

    public FormService(FormRepo formRepo) {
        this.formRepo = formRepo;
    }

    public FormDTO addForm(FormDTO formDTO) throws RegionAlreadyExistException {
        FormEntity form = new FormEntity(formDTO.getForm(), formDTO.getPrefix());
//        if (formRepo.findByForm(form.getForm()) != null && formRepo.findByPrefix(form.getPrefix()) != null){
//            throw new RegionAlreadyExistException("This Form already created");
//        }
        return FormDTO.toCreateModel(formRepo.save(form));
    }

    public List<FormForListDTO> getAll(){
        List<FormEntity> entities = (List<FormEntity>) formRepo.findAll();
        List<FormForListDTO> dtos = new ArrayList<>();
        for (FormEntity entity: entities){
            dtos.add(new FormForListDTO(entity.getId(), entity.getForm(), entity.getPrefix()));
        }
        return dtos;
    }

    public FormDTO getOne(Long id) throws FormNotFoundException {
        FormEntity form = formRepo.findById(id).get();
        if (form == null){
            throw new FormNotFoundException("Form not found!");
        }
        return FormDTO.toModel(form);
    }

    public Long deleteForm(Long id){
        formRepo.deleteById(id);
        return id;
    }

    public FormDTO putForm(Long id, FormDTO formDTO){
        FormEntity entity = formRepo.findById(id).get();
        entity.setForm(formDTO.getForm());
        entity.setPrefix(formDTO.getPrefix());
        return FormDTO.toCreateModel(formRepo.save(entity));
    }
}
