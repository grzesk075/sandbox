package pl.grzesk075.sandbox.microtasks.elm;

import pl.grzesk075.sandbox.microtasks.lib.Outage;
import pl.grzesk075.sandbox.microtasks.lib.OutageDTO;

/**
 * Zadanie nr 3.
 * Zoptymalizować funkcję (poprawić kod bez zmiany funkcjonalności).
 * @author grzesk
 */
public abstract class Test3e
{
    public static OutageDTO convert2DTO( Outage otg)
    {
        if( otg == null)
            return null;
        
        if( otg != null && otg.getStatus() == Outage.OutageStatusEnum.CANCELED)
            return null;
        
        if( otg != null && otg.getStatus() == Outage.OutageStatusEnum.FINISHED)
            return null;
        
        OutageDTO dto = new OutageDTO();
        dto.setCustomerCount( otg.getCustomerCount());
        
        if( otg.getOrder() == 1 || otg.getOrder() == 2)
            dto.setFinished();
        
        if( Outage.OutageStatusEnum.SAVED.equals( otg.getStatus()) && ( otg.getOrder() == 1 || otg.getOrder() == 2) && otg.getType() < 0)
        {
            dto.setStatus( otg.getStatus());
            dto.setOrder( otg.getOrder());
            dto.setInfo( otg.getInfo());
            
            dto.setType( otg.getType() - 1);
        }
        
        if( Outage.OutageStatusEnum.SAVED.equals( otg.getStatus()) && ( otg.getOrder() == 1 || otg.getOrder() == 2) && otg.getType() > 5)
        {
            dto.setStatus( otg.getStatus());
            dto.setOrder( otg.getOrder());
            dto.setInfo( otg.getInfo());
            
            dto.setType( otg.getType() + 1);
        }
        
        if( Outage.OutageStatusEnum.SAVED.equals( otg.getStatus()))
            dto.setCurrent();
        
        return dto;
    }
}
