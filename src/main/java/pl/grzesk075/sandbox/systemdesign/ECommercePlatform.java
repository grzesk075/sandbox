package pl.grzesk075.sandbox.systemdesign;

/**
 * Design shopping platform like shopify.
 * Key features:
 * 1. Automated store front creation. [templates]
 * 2. Careless hosting, networking. [Cloud]
 * 3. Isolation and security. [Containers]
 * Main actors: ShopOwner, ShoppingPlatform, Shop, Customer, Cloud.
 * Main modules:
 * Computing Cloud (base platform),
 * Store creation and maintenance module (orchestrator),
 * Docker Templates with shops [DB, rest db API, web app],
 * List of customized Shops (running containers and images),
 * Health check monitor,
 * Billing module.
 * Pros and cons:
 * + Cloud gives hosting, scaling, security, backups and no risk of single point of failure.
 * + No risk of cross-shops side effects.
 * - Maintenence (upgrades of many instances of web apps and databases in containers).
 *
 * Details of shop are in ECommercePortal.
 */
public class ECommercePlatform {
}
