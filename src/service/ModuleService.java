package service;

import model.*;
import model.Module;

import java.util.*;

public class ModuleService implements BaseService<Module> {
    List<Module> moduls = new ArrayList<>();

    @Override
    public Module add(Module modul) {
        if (hasModule(modul.getId())) {
            return null;
        }
        moduls.add(modul);
        return modul;
    }

    private boolean hasModule(UUID id) {
        for (Module modul : moduls) {
            if (modul.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(UUID id) {
        for(Module mod: moduls) {
            if (mod.getId().equals(id)) {
                moduls.remove(mod);
            }
        }
    }

    public Module update(UUID id, Module module) {
        for (int i = 0; i < moduls.size(); i++) {
            if (moduls.get(i).getId().equals(id)) {
                moduls.set(i, module);
                return module;
            }
        }
        return null;
    }
    @Override
    public List<Module> list() {
        if (moduls.isEmpty()) {
            return null;
        }
        return moduls;
    }
}
