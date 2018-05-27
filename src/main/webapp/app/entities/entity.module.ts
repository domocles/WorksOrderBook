import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { WorksOrderBookSupplierModule } from './supplier/supplier.module';
import { WorksOrderBookAddressModule } from './address/address.module';
import { WorksOrderBookCustomerModule } from './customer/customer.module';
import { WorksOrderBookProductModule } from './product/product.module';
import { WorksOrderBookMaterialModule } from './material/material.module';
import { WorksOrderBookRawComponentModule } from './raw-component/raw-component.module';
import { WorksOrderBookBOMModule } from './bom/bom.module';
import { WorksOrderBookBOMMaterialLineModule } from './bom-material-line/bom-material-line.module';
import { WorksOrderBookBOMComponentLineModule } from './bom-component-line/bom-component-line.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        WorksOrderBookSupplierModule,
        WorksOrderBookAddressModule,
        WorksOrderBookCustomerModule,
        WorksOrderBookProductModule,
        WorksOrderBookMaterialModule,
        WorksOrderBookRawComponentModule,
        WorksOrderBookBOMModule,
        WorksOrderBookBOMMaterialLineModule,
        WorksOrderBookBOMComponentLineModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WorksOrderBookEntityModule {}
