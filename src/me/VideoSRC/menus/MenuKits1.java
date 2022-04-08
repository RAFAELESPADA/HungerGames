/*      */ package me.VideoSRC.menus;

/*      */
/*      */ import java.util.ArrayList;

/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.ChatColor;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.EventHandler;
/*      */ import org.bukkit.event.Listener;
/*      */ import org.bukkit.event.inventory.InventoryClickEvent;
/*      */ import org.bukkit.inventory.Inventory;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.meta.ItemMeta;

import me.VideoSRC.api.Strings;

/*      */
/*      */ public class MenuKits1 implements Listener
/*      */ {
	/* 20 */ public static ArrayList<String> ListaKits2 = new ArrayList();

	/*      */
	/*      */
	/*      */ public static void InventarioKitsGui(Player p)
	/*      */ {
		/* 25 */ Inventory inv = Bukkit.getServer().createInventory(p, 54, "§8Your Kits! §a1");

		/* 26 */ ItemStack vidro = new ItemStack(Material.GLASS_PANE);
		/* 27 */ ItemMeta metav = vidro.getItemMeta();
		/* 28 */ metav.setDisplayName(" ");
		/* 29 */ vidro.setItemMeta(metav);
		/*      */
		/* 31 */ inv.setItem(0, vidro);
		/* 32 */ inv.setItem(1, vidro);
		/* 33 */ inv.setItem(2, vidro);
		/* 34 */ inv.setItem(3, vidro);
		/* 35 */ inv.setItem(4, vidro);
		/* 36 */ inv.setItem(5, vidro);
		/* 37 */ inv.setItem(6, vidro);
		/* 38 */ inv.setItem(7, vidro);
		/* 39 */ inv.setItem(8, vidro);

		/* 53 */ ItemStack Carpets = new ItemStack(Material.BLUE_CARPET);
		/* 55 */ ItemMeta metacarpets = Carpets.getItemMeta();
		/* 56 */ metacarpets.setDisplayName(Strings.nomeserver);
		/* 57 */ Carpets.setItemMeta(metacarpets);
		/* 58 */ inv.setItem(4, Carpets);
		/*     */
		/* 77 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 79 */ ItemStack pyro = new ItemStack(Material.CAKE);
			/* 80 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 81 */ metapyro.setDisplayName("§aSurprise");
			/* 82 */ ArrayList<String> descpyro = new ArrayList();
			/* 83 */
			/* 84 */ descpyro.add(ChatColor.GRAY + "§7Gets a random kit");
			/* 85 */ descpyro.add(ChatColor.GRAY + "§7When the game starts!");
			/* 86 */ metapyro.setLore(descpyro);
			/* 87 */ pyro.setItemMeta(metapyro);
			/* 88 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 482 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 484 */ ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			/* 485 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 486 */ metapyro.setDisplayName("§aFisherman");
			/* 487 */ ArrayList<String> descpyro = new ArrayList();
			/* 488 */
			/* 489 */ descpyro.add(ChatColor.GRAY + "§7With your fishing rod teleports");
			/* 490 */ descpyro.add(ChatColor.GRAY + "§7Players to your position!");
			/* 491 */ metapyro.setLore(descpyro);
			/* 492 */ pyro.setItemMeta(metapyro);
			/* 493 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 521 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 523 */ ItemStack pyro = new ItemStack(Material.SNOWBALL);
			/* 524 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 525 */ metapyro.setDisplayName("§aSwitcher");
			/* 526 */ ArrayList<String> descpyro = new ArrayList();
			/* 527 */
			/* 528 */ descpyro.add(ChatColor.GRAY + "§7Switch places with");
			/* 529 */ descpyro.add(ChatColor.GRAY + "§7Your Enemy");
			descpyro.add(ChatColor.GRAY + "§7Using snowballs");
			/* 530 */ metapyro.setLore(descpyro);
			/* 531 */ pyro.setItemMeta(metapyro);
			/* 532 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 534 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 536 */ ItemStack pyro = new ItemStack(Material.TNT);
			/* 537 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 538 */ metapyro.setDisplayName("§aTank");
			/* 539 */ ArrayList<String> descpyro = new ArrayList();
			/* 540 */
			/* 541 */ descpyro.add(ChatColor.GRAY + "§7When kill a player create a explosion");
			/* 542 */ descpyro.add(ChatColor.GRAY + "§7Also you are immune to explosions");
			/* 543 */ metapyro.setLore(descpyro);
			/* 544 */ pyro.setItemMeta(metapyro);
			/* 545 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 547 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 549 */ ItemStack pyro = new ItemStack(Material.STONE_AXE);
			/* 550 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 551 */ metapyro.setDisplayName("§aThor");
			/* 552 */ ArrayList<String> descpyro = new ArrayList();
			/* 553 */
			/* 554 */ descpyro.add(ChatColor.GRAY + "§7Do thunderbolts with");
			/* 555 */ descpyro.add(ChatColor.GRAY + "§7Your Axe!");
			/* 556 */ metapyro.setLore(descpyro);
			/* 557 */ pyro.setItemMeta(metapyro);
			/* 558 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 560 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 562 */ ItemStack pyro = new ItemStack(Material.CLOCK);
			/* 563 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 564 */ metapyro.setDisplayName("§aTimelord");
			/* 565 */ ArrayList<String> descpyro = new ArrayList();
			/* 566 */
			/* 567 */ descpyro.add(ChatColor.GRAY + "§7Freeze your oponents");
			/* 568 */ descpyro.add(ChatColor.GRAY + "§7To Kill Them quickly");
			/* 569 */ metapyro.setLore(descpyro);
			/* 570 */ pyro.setItemMeta(metapyro);
			/* 571 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 573 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 575 */ ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			/* 576 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 577 */ metapyro.setDisplayName("§aTurtle");
			/* 578 */ ArrayList<String> descpyro = new ArrayList();
			/* 579 */
			/* 580 */ descpyro.add(ChatColor.GRAY + "§7Press shift and have");
			/* 581 */ descpyro.add(ChatColor.GRAY + "§7damage reduced");
			/* 582 */ metapyro.setLore(descpyro);
			/* 583 */ pyro.setItemMeta(metapyro);
			/* 584 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 586 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 588 */ ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			/* 589 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 590 */ metapyro.setDisplayName("§aViper");
			/* 591 */ ArrayList<String> descpyro = new ArrayList();
			/* 592 */
			/* 593 */ descpyro.add(ChatColor.GRAY + "§7Have a 33% of chance of giving");
			/* 594 */ descpyro.add(ChatColor.GRAY + "§7Poison on each hit");
			/* 595 */ metapyro.setLore(descpyro);
			/* 596 */ pyro.setItemMeta(metapyro);
			/* 597 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 599 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 601 */ ItemStack pyro = new ItemStack(Material.DIRT);
			/* 602 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 603 */ metapyro.setDisplayName("§aWorm");
			/* 604 */ ArrayList<String> descpyro = new ArrayList();
			/* 606 */ descpyro.add(ChatColor.GRAY + "§7Gets dirt instantly and gets");
			/* 607 */ descpyro.add(ChatColor.GRAY + "§7Regeneration effect");
			/* 608 */ metapyro.setLore(descpyro);
			/* 609 */ pyro.setItemMeta(metapyro);
			/* 610 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 71 */ if (p.hasPermission("tag.vip")) {
			/* 72 */ ItemStack pyro = new ItemStack(Material.SPONGE);
			/* 73 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 74 */ metapyro.setDisplayName("§aLauncher");
			/* 75 */ ArrayList<String> descpyro = new ArrayList();
			/* 76 */ descpyro.add(ChatColor.GRAY + "§7Create a jumppad with");
			/* 77 */ descpyro.add(ChatColor.GRAY + "§7Your sponges!");
			/* 78 */ metapyro.setLore(descpyro);
			/* 79 */ pyro.setItemMeta(metapyro);
			/* 80 */ inv.addItem(new ItemStack[] { pyro });
			/*     */ }

		/* 495 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 497 */ ItemStack pyro = new ItemStack(Material.ENCHANTED_BOOK);
			/* 498 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 499 */ metapyro.setDisplayName("§aSpecialist");
			/* 500 */ ArrayList<String> descpyro = new ArrayList();
			/* 501 */
			/* 502 */ descpyro.add(ChatColor.GRAY + "§7Have a portable enchamentment");
			/* 503 */ descpyro.add(ChatColor.GRAY + "§7And receives 1 xp on each kill");
			/* 504 */ metapyro.setLore(descpyro);
			/* 505 */ pyro.setItemMeta(metapyro);
			/* 506 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 508 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 510 */ ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			/* 511 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 512 */ metapyro.setDisplayName("§aStomper");
			/* 513 */ ArrayList<String> descpyro = new ArrayList();
			/* 514 */
			/* 515 */ descpyro.add(ChatColor.GRAY + "§7Smash your enemies");
			/* 516 */ descpyro.add(ChatColor.GRAY + "§7Good for towers");
			/* 517 */ metapyro.setLore(descpyro);
			/* 518 */ pyro.setItemMeta(metapyro);
			/* 519 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 90 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 92 */ ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
			/* 93 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 94 */ metapyro.setDisplayName("§aMadman");
			/* 95 */ ArrayList<String> descpyro = new ArrayList();
			/* 96 */ descpyro.add(ChatColor.GRAY + "§7Leave your enemies with");
			/* 97 */ descpyro.add(ChatColor.GRAY + "§7Weakness effect!");
			/* 98 */ metapyro.setLore(descpyro);
			/* 99 */ pyro.setItemMeta(metapyro);
			/* 100 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 443 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 445 */ ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			/* 446 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 447 */ metapyro.setDisplayName("§aPoseidon");
			/* 448 */ ArrayList<String> descpyro = new ArrayList();
			/* 449 */
			/* 450 */ descpyro.add(ChatColor.GRAY + "§7Receives strenght and speed");
			/* 451 */ descpyro.add(ChatColor.GRAY + "§7On Water!");
			/* 452 */ metapyro.setLore(descpyro);
			/* 453 */ pyro.setItemMeta(metapyro);
			/* 454 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 114 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 116 */ ItemStack pyro = new ItemStack(Material.STICK);
			/* 117 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 118 */ metapyro.setDisplayName("§aGrandpa");
			/* 119 */ ArrayList<String> descpyro = new ArrayList();
			/* 120 */ descpyro.add(ChatColor.GRAY + "§7Gets a stick with");
			/* 121 */ descpyro.add(ChatColor.GRAY + "§7Knockback 2!");
			/* 122 */ metapyro.setLore(descpyro);
			/* 123 */ pyro.setItemMeta(metapyro);
			/* 124 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 456 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 458 */ ItemStack pyro = new ItemStack(Material.WOODEN_HOE);
			/* 459 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 460 */ metapyro.setDisplayName("§aReaper");
			/* 461 */ ArrayList<String> descpyro = new ArrayList();
			/* 462 */
			/* 463 */ descpyro.add(ChatColor.GRAY + "§7When hit a player gives");
			/* 464 */ descpyro.add(ChatColor.GRAY + "§7him wither effect");
			/* 465 */ metapyro.setLore(descpyro);
			/* 466 */ pyro.setItemMeta(metapyro);
			/* 467 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 138 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 140 */ ItemStack pyro = new ItemStack(Material.CRAFTING_TABLE);
			/* 141 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 142 */ metapyro.setDisplayName("§aCrafter");
			/* 143 */ ArrayList<String> descpyro = new ArrayList();
			/* 144 */ descpyro.add(ChatColor.GRAY + "§7Have a portable");
			/* 145 */ descpyro.add(ChatColor.GRAY + "§7Crafting Table");
			/* 146 */ metapyro.setLore(descpyro);
			/* 147 */ pyro.setItemMeta(metapyro);
			/* 148 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 469 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 471 */ ItemStack pyro = new ItemStack(Material.COBWEB);
			/* 472 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 473 */ metapyro.setDisplayName("§aSnail");
			/* 474 */ ArrayList<String> descpyro = new ArrayList();
			/* 475 */
			/* 476 */ descpyro.add(ChatColor.GRAY + "§7When hiting a player has 33%");
			/* 477 */ descpyro.add(ChatColor.GRAY + "§7chance to give slowness to him!");
			/* 478 */ metapyro.setLore(descpyro);
			/* 479 */ pyro.setItemMeta(metapyro);
			/* 480 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }

		/* 53 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 55 */ ItemStack pyro = new ItemStack(Material.FIREWORK_ROCKET);
			/* 56 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 57 */ metapyro.setDisplayName("§aKangaroo");
			/* 58 */ ArrayList<String> descpyro = new ArrayList();
			/* 59 */ descpyro.add(ChatColor.GRAY + "§7Do double jumps with");
			/* 60 */ descpyro.add(ChatColor.GRAY + "§7Your firework!");
			/* 61 */ metapyro.setLore(descpyro);
			/* 62 */ pyro.setItemMeta(metapyro);
			/* 63 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 213 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 215 */ ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
			/* 216 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 217 */ metapyro.setDisplayName("§aEnderman");
			/* 218 */ ArrayList<String> descpyro = new ArrayList();
			/* 219 */ descpyro.add(ChatColor.GRAY + "§7Gets 3 enderpearls and gains more");
			/* 220 */ descpyro.add(ChatColor.GRAY + "§7When killing players");
			/* 221 */ metapyro.setLore(descpyro);
			/* 222 */ pyro.setItemMeta(metapyro);
			/* 223 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 225 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 227 */ ItemStack pyro = new ItemStack(Material.ANVIL);
			/* 228 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 229 */ metapyro.setDisplayName("§aAnchor");
			/* 230 */ ArrayList<String> descpyro = new ArrayList();
			/* 231 */ descpyro.add(ChatColor.GRAY + "§7Dont receive or");
			/* 232 */ descpyro.add(ChatColor.GRAY + "§7Give Knockback");
			/* 233 */ metapyro.setLore(descpyro);
			/* 234 */ pyro.setItemMeta(metapyro);
			/* 235 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 237 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 239 */ ItemStack pyro = new ItemStack(Material.ACACIA_SAPLING);
			/* 240 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 241 */ metapyro.setDisplayName("§aCultivator");
			/* 242 */ ArrayList<String> descpyro = new ArrayList();
			/* 243 */ descpyro.add(ChatColor.GRAY + "§7Plants seeds and gets it");
			/* 244 */ descpyro.add(ChatColor.GRAY + "§7grown instantly!");
			/* 245 */ metapyro.setLore(descpyro);
			/* 246 */ pyro.setItemMeta(metapyro);
			/* 247 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 249 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 251 */ ItemStack pyro = new ItemStack(Material.SADDLE);
			/* 252 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 253 */ metapyro.setDisplayName("§aHulk");
			/* 254 */ ArrayList<String> descpyro = new ArrayList();
			/* 255 */ descpyro.add(ChatColor.GRAY + "§7Get players on your back");
			/* 256 */ descpyro.add(ChatColor.GRAY + "§7And kills them easily");
			/* 257 */ metapyro.setLore(descpyro);
			/* 258 */ pyro.setItemMeta(metapyro);
			/* 259 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 261 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 263 */ ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
			/* 264 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 265 */ metapyro.setDisplayName("§aFireman");
			/* 266 */ ArrayList<String> descpyro = new ArrayList();
			/* 267 */ descpyro.add(ChatColor.GRAY + "§7Dont receive damage to fire");
			/* 268 */ descpyro.add(ChatColor.GRAY + "§7Wood Swords are flamable in your hands");
			/* 269 */ metapyro.setLore(descpyro);
			/* 270 */ pyro.setItemMeta(metapyro);
			/* 271 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 273 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 275 */ ItemStack pyro = new ItemStack(Material.DIAMOND_BOOTS);
			/* 276 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 277 */ metapyro.setDisplayName("§aTower");
			/* 278 */ ArrayList<String> descpyro = new ArrayList();
			/* 279 */ descpyro.add(ChatColor.GRAY + "§7Perfect time for towers!");
			/* 280 */ descpyro.add(ChatColor.GRAY + "§7Kits Stomper + Worm!");
			/* 281 */ metapyro.setLore(descpyro);
			/* 282 */ pyro.setItemMeta(metapyro);
			/* 283 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 285 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 287 */ ItemStack pyro = new ItemStack(Material.IRON_AXE);
			/* 288 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 289 */ metapyro.setDisplayName("§aViking");
			/* 290 */ ArrayList<String> descpyro = new ArrayList();
			/* 291 */ descpyro.add(ChatColor.GRAY + "§7Do more damage with");
			/* 292 */ descpyro.add(ChatColor.GRAY + "§7Axes!");
			/* 293 */ metapyro.setLore(descpyro);
			/* 294 */ pyro.setItemMeta(metapyro);
			/* 295 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 297 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 299 */ ItemStack pyro = new ItemStack(Material.STONE_PRESSURE_PLATE);
			/* 300 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 301 */ metapyro.setDisplayName("§aDemoman");
			/* 302 */ ArrayList<String> descpyro = new ArrayList();
			/* 303 */ descpyro.add(ChatColor.GRAY + "§7Create a trap with");
			/* 304 */ descpyro.add(ChatColor.GRAY + "§7Gravel and Stone Plate!");
			/* 305 */ metapyro.setLore(descpyro);
			/* 306 */ pyro.setItemMeta(metapyro);
			/* 307 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 321 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 323 */ ItemStack pyro = new ItemStack(Material.NETHER_PORTAL);
			/* 324 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 325 */ metapyro.setDisplayName("§aEndermage");
			/* 326 */ ArrayList<String> descpyro = new ArrayList();
			/* 327 */ descpyro.add(ChatColor.GRAY + "§7Pull players with");
			/* 328 */ descpyro.add(ChatColor.GRAY + "§7Your portal!");
			/* 329 */ metapyro.setLore(descpyro);
			/* 330 */ pyro.setItemMeta(metapyro);
			/* 331 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 345 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 347 */ ItemStack pyro = new ItemStack(Material.COAL);
			/* 348 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 349 */ metapyro.setDisplayName("§aForger");
			/* 350 */ ArrayList<String> descpyro = new ArrayList();
			/* 351 */ descpyro.add(ChatColor.GRAY + "§7Smelt ores in your");
			/* 352 */ descpyro.add(ChatColor.GRAY + "§7Inventory");
			/* 353 */ metapyro.setLore(descpyro);
			/* 354 */ pyro.setItemMeta(metapyro);
			/* 355 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 357 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 359 */ ItemStack pyro = new ItemStack(Material.IRON_BARS);
			/* 360 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 361 */ metapyro.setDisplayName("§aGladiator");
			/* 362 */ ArrayList<String> descpyro = new ArrayList();
			/* 363 */ descpyro.add(ChatColor.GRAY + "§7Generate a 1v1 arena");
			/* 364 */ descpyro.add(ChatColor.GRAY + "§7Against a player!");
			/* 365 */ metapyro.setLore(descpyro);
			/* 366 */ pyro.setItemMeta(metapyro);
			/* 367 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 369 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 371 */ ItemStack pyro = new ItemStack(Material.LEAD);
			/* 372 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 373 */ metapyro.setDisplayName("§aGrappler (§cMaintanance)");
			/* 374 */ ArrayList<String> descpyro = new ArrayList();
			/* 375 */ descpyro.add(ChatColor.GRAY + "§7With your lead");
			/* 376 */ descpyro.add(ChatColor.GRAY + "§7Moves quickly");
			/* 377 */ metapyro.setLore(descpyro);
			/* 378 */ pyro.setItemMeta(metapyro);
			/* 379 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 381 */ /* 126 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 128 */ ItemStack pyro = new ItemStack(Material.DANDELION);
			/* 129 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 130 */ metapyro.setDisplayName("§aCopyCat");
			/* 131 */ ArrayList<String> descpyro = new ArrayList();
			/* 132 */ descpyro.add(ChatColor.GRAY + "§7Steals a player kit");
			/* 133 */ descpyro.add(ChatColor.GRAY + "§7When killing him!");
			/* 134 */ metapyro.setLore(descpyro);
			/* 135 */ pyro.setItemMeta(metapyro);
			/* 136 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 381 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 383 */ ItemStack pyro = new ItemStack(Material.CLAY_BALL);
			/* 384 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 385 */ metapyro.setDisplayName("§aJellyfish");
			/* 386 */ ArrayList<String> descpyro = new ArrayList();
			/* 387 */ descpyro.add(ChatColor.GRAY + "§7Put water with your hand");
			/* 388 */ descpyro.add(ChatColor.GRAY + "§7Who gets in the water");
			          descpyro.add(ChatColor.GRAY + "§7Receives poison");
			/* 389 */ metapyro.setLore(descpyro);
			/* 390 */ pyro.setItemMeta(metapyro);
			/* 391 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 393 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 395 */ ItemStack pyro = new ItemStack(Material.WOODEN_AXE);
			/* 396 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 397 */ metapyro.setDisplayName("§aLumberjack");
			/* 398 */ ArrayList<String> descpyro = new ArrayList();
			/* 399 */ descpyro.add(ChatColor.GRAY + "§7Broken tress");
			/* 400 */ descpyro.add(ChatColor.GRAY + "§7Instantly");
			/* 401 */ metapyro.setLore(descpyro);
			/* 402 */ pyro.setItemMeta(metapyro);
			/* 403 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 405 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 407 */ ItemStack pyro = new ItemStack(Material.STONE_PICKAXE);
			/* 408 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 409 */ metapyro.setDisplayName("§aMiner");
			/* 410 */ ArrayList<String> descpyro = new ArrayList();
			/* 411 */ descpyro.add(ChatColor.GRAY + "§7Broken any ores instantly");
			/* 412 */ descpyro.add(ChatColor.GRAY + "§7Also when you eats");
			descpyro.add(ChatColor.GRAY + "§7A apple you get mining speed");
			/* 413 */ metapyro.setLore(descpyro);
			/* 414 */ pyro.setItemMeta(metapyro);
			/* 415 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 417 */ if (p.hasPermission("tag.membro"))
		/*      */ {
			/* 419 */ ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			/* 420 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 421 */ metapyro.setDisplayName("§aMonk");
			/* 422 */ ArrayList<String> descpyro = new ArrayList();
			/* 423 */
			/* 424 */ descpyro.add(ChatColor.GRAY + "§7Desarms your oponnent");
			/* 425 */ descpyro.add(ChatColor.GRAY + "§7With your kit item!");
			/* 426 */ metapyro.setLore(descpyro);
			/* 427 */ pyro.setItemMeta(metapyro);
			/* 428 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }
		/* 430 */ if (p.hasPermission("tag.vip"))
		/*      */ {
			/* 432 */ ItemStack pyro = new ItemStack(Material.EMERALD);
			/* 433 */ ItemMeta metapyro = pyro.getItemMeta();
			/* 434 */ metapyro.setDisplayName("§aNinja");
			/* 435 */ ArrayList<String> descpyro = new ArrayList();
			/* 436 */
			/* 437 */ descpyro.add(ChatColor.GRAY + "§7Teleport to last player");
			/* 438 */ descpyro.add(ChatColor.GRAY + "§7You hurt pressing shift");
			/* 439 */ metapyro.setLore(descpyro);
			/* 440 */ pyro.setItemMeta(metapyro);
			/* 441 */ inv.addItem(new ItemStack[] { pyro });
			/*      */ }

		/*      */ ItemStack[] arrayOfItemStack;
		/* 613 */ int descpyro = (arrayOfItemStack = inv.getContents()).length;
		/* 614 */ for (int metapyro = 0; metapyro < descpyro; metapyro++)
		/*      */ {
			/* 616 */ ItemStack item = arrayOfItemStack[metapyro];
			/* 617 */ if (item == null) {
				/*      */ }
			/*      */ }
		/* 621 */ p.openInventory(inv);
		/* 622 */ ListaKits2.add(p.getName());
		/*      */ }

	/*      */
	/*      */ @EventHandler
	/*      */ public void onPlayerCLickInventry(InventoryClickEvent e)
	/*      */ {
		/* 639 */ Player p = (Player) e.getWhoClicked();
		/* 640 */ if ((e.getView().getTitle().equals("§8Your Kits! §a1")) && (e.getCurrentItem() != null)
				&& (e.getCurrentItem().getType() != Material.AIR))
		/*      */ {
			/* 642 */ e.setCancelled(true);
			/* 643 */ if (e.getCurrentItem().getType() == Material.INK_SAC)
			/*      */ {
				/*      */ }
			/* 643 */ if (e.getCurrentItem().getType() == Material.GUNPOWDER)
			/*      */ {
				/* 645 */ e.setCancelled(true);
				/* 647 */ return;
				/*      */ }
			/* 649 */ if (e.getCurrentItem().getType() == Material.FIRE)
			/*      */ {
				/* 651 */ e.setCancelled(true);
				/* 652 */ p.closeInventory();
				/* 653 */ p.chat("/kit firer");
				/* 654 */ return;
				/*      */ }
			/* 663 */ if (e.getCurrentItem().getType() == Material.MUSHROOM_STEW)
			/*      */ {
				/* 665 */ e.setCancelled(true);
				/* 666 */ p.closeInventory();
				/* 667 */ p.chat("/kit hermit");
				/* 668 */ return;
				/*      */ }
			/* 670 */ if (e.getCurrentItem().getType() == Material.CAKE)
			/*      */ {
				/* 672 */ e.setCancelled(true);
				/* 673 */ p.closeInventory();
				/* 674 */ p.chat("/kit surprise");
				/* 675 */ return;
				/*      */ }
			/* 684 */ if (e.getCurrentItem().getType() == Material.CRAFTING_TABLE)
			/*      */ {
				/* 686 */ e.setCancelled(true);
				/* 687 */ p.closeInventory();
				/* 688 */ p.chat("/kit crafter");
				/* 689 */ return;
				/*      */ }
			/* 691 */ if (e.getCurrentItem().getType() == Material.OAK_SAPLING)
			/*      */ {
				/* 693 */ e.setCancelled(true);
				/* 694 */ p.closeInventory();
				/* 695 */ p.chat("/kit cultivator");
				/* 696 */ return;
				/*      */ }
			/* 698 */ if (e.getCurrentItem().getType() == Material.LEATHER)
			/*      */ {
				/* 700 */ e.setCancelled(true);
				/* 701 */ p.closeInventory();
				/* 702 */ p.chat("/kit backpacker");
				/* 703 */ return;
				/*      */ }
			/* 705 */ if (e.getCurrentItem().getType() == Material.STONE_PRESSURE_PLATE)
			/*      */ {
				/* 707 */ e.setCancelled(true);
				/* 708 */ p.closeInventory();
				/* 709 */ p.chat("/kit demoman");
				/* 710 */ return;
				/*      */ }
			/* 719 */ if (e.getCurrentItem().getType() == Material.NETHER_PORTAL)
			/*      */ {
				/* 721 */ e.setCancelled(true);
				/* 722 */ p.closeInventory();
				/* 723 */ p.chat("/kit endermage");
				/* 724 */ return;
				/*      */ }
			/* 726 */ if (e.getCurrentItem().getType() == Material.FISHING_ROD)
			/*      */ {
				/* 728 */ e.setCancelled(true);
				/* 729 */ p.closeInventory();
				/* 730 */ p.chat("/kit fisherman");
				/* 731 */ return;
				/*      */ }
			/* 733 */ if (e.getCurrentItem().getType() == Material.STICK)
			/*      */ {
				/* 735 */ e.setCancelled(true);
				/* 736 */ p.closeInventory();
				/* 737 */ p.chat("/kit grandpa");
				/* 738 */ return;
				/*      */ }
			/* 740 */ if (e.getCurrentItem().getType() == Material.ANVIL)
			/*      */ {
				/* 742 */ e.setCancelled(true);
				/* 743 */ p.closeInventory();
				/* 744 */ p.chat("/kit anchor");
				/* 745 */ return;
				/*      */ }
			/* 747 */ if (e.getCurrentItem().getType() == Material.COAL)
			/*      */ {
				/* 749 */ e.setCancelled(true);
				/* 750 */ p.closeInventory();
				/* 751 */ p.chat("/kit forger");
				/* 752 */ return;
				/*      */ }
			/* 754 */ if (e.getCurrentItem().getType() == Material.IRON_BARS)
			/*      */ {
				/* 756 */ e.setCancelled(true);
				/* 757 */ p.closeInventory();
				/* 758 */ p.chat("/kit gladiator");
				/* 759 */ return;
				/*      */ }
			/* 761 */ if (e.getCurrentItem().getType() == Material.ENDER_PEARL)
			/*      */ {
				/* 763 */ e.setCancelled(true);
				/* 764 */ p.closeInventory();
				/* 765 */ p.chat("/kit enderman");
				/* 766 */ return;
				/*      */ }
			/* 768 */ if (e.getCurrentItem().getType() == Material.SAND)
			/*      */ {
				/* 770 */ e.setCancelled(true);
				/* 771 */ p.closeInventory();
				/* 772 */ p.chat("/kit desert");
				/* 773 */ return;
				/*      */ }
			/* 775 */ if (e.getCurrentItem().getType() == Material.IRON_INGOT)
			/*      */ {
				/* 777 */ e.setCancelled(true);
				/* 778 */ p.closeInventory();
				/* 779 */ p.chat("/kit durability");
				/* 780 */ return;
				/*      */ }
			/* 782 */ if (e.getCurrentItem().getType() == Material.LEAD)
			/*      */ {
				/* 784 */ e.setCancelled(true);
				/* 785 */ p.closeInventory();
				/* 786 */ p.sendMessage("O kit grappler esta em manutenção");
				/* 787 */ return;
				/*      */ }
			/* 789 */ if (e.getCurrentItem().getType() == Material.SADDLE)
			/*      */ {
				/* 791 */ e.setCancelled(true);
				/* 792 */ p.closeInventory();
				/* 793 */ p.chat("/kit hulk");
				/* 794 */ return;
				/*      */ }
			/* 796 */ if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS)
			/*      */ {
				/* 798 */ e.setCancelled(true);
				/* 799 */ p.closeInventory();
				/* 800 */ p.chat("/kit tower");
				/* 801 */ return;
				/*      */ }
			/* 803 */ if (e.getCurrentItem().getType() == Material.CLAY_BALL)
			/*      */ {
				/* 805 */ e.setCancelled(true);
				/* 806 */ p.closeInventory();
				/* 807 */ p.chat("/kit jellyfish");
				/* 808 */ return;
				/*      */ }
			/* 810 */ if (e.getCurrentItem().getType() == Material.FIREWORK_ROCKET)
			/*      */ {
				/* 812 */ e.setCancelled(true);
				/* 813 */ p.closeInventory();
				/* 814 */ p.chat("/kit kangaroo");
				/* 815 */ return;
				/*      */ }
			/* 817 */ if (e.getCurrentItem().getType() == Material.DANDELION)
			/*      */ {
				/* 819 */ e.setCancelled(true);
				/* 820 */ p.closeInventory();
				/* 821 */ p.chat("/kit copycat");
				/* 822 */ return;
				/*      */ }
			/* 824 */ if (e.getCurrentItem().getType() == Material.WOODEN_AXE)
			/*      */ {
				/* 826 */ e.setCancelled(true);
				/* 827 */ p.closeInventory();
				/* 828 */ p.chat("/kit lumberjack");
				/* 829 */ return;
				/*      */ }
			/* 831 */ if (e.getCurrentItem().getType() == Material.STONE_PICKAXE)
			/*      */ {
				/* 833 */ e.setCancelled(true);
				/* 834 */ p.closeInventory();
				/* 835 */ p.chat("/kit miner");
				/* 836 */ return;
				/*      */ }
			/* 845 */ if (e.getCurrentItem().getType() == Material.BLAZE_ROD)
			/*      */ {
				/* 847 */ e.setCancelled(true);
				/* 848 */ p.closeInventory();
				/* 849 */ p.chat("/kit monk");
				/* 850 */ return;
				/*      */ }
			/* 852 */ if (e.getCurrentItem().getType() == Material.EMERALD)
			/*      */ {
				/* 854 */ e.setCancelled(true);
				/* 855 */ p.closeInventory();
				/* 856 */ p.chat("/kit ninja");
				/* 857 */ return;
				/*      */ }
			/* 866 */ if (e.getCurrentItem().getType() == Material.WATER_BUCKET)
			/*      */ {
				/* 868 */ e.setCancelled(true);
				/* 869 */ p.closeInventory();
				/* 870 */ p.chat("/kit poseidon");
				/* 871 */ return;
				/*      */ }
			/* 866 */ if (e.getCurrentItem().getType() == Material.NETHER_STAR)
			/*      */ {
				/* 868 */ e.setCancelled(true);
				/* 869 */ p.closeInventory();
				/* 870 */ p.chat("/kit blink");
				/* 871 */ return;
				/*      */ }
			/* 866 */ if (e.getCurrentItem().getType() == Material.WHITE_CARPET)
			/*      */ {
				/* 868 */ e.setCancelled(true);
				/* 869 */ p.closeInventory();
				/* 870 */ p.chat("/kit aladdin");
				/* 871 */ return;
				/*      */ }
			/* 873 */ if (e.getCurrentItem().getType() == Material.IRON_AXE)
			/*      */ {
				/* 875 */ e.setCancelled(true);
				/* 876 */ p.closeInventory();
				/* 877 */ p.chat("/kit viking");
				/* 878 */ return;
				/*      */ }
			/* 880 */ if (e.getCurrentItem().getType() == Material.LAVA_BUCKET)
			/*      */ {
				/* 882 */ e.setCancelled(true);
				/* 883 */ p.closeInventory();
				/* 884 */ p.chat("/kit fireman");
				/* 885 */ return;
				/*      */ }
			/* 887 */ if (e.getCurrentItem().getType() == Material.ENCHANTED_BOOK)
			/*      */ {
				/* 889 */ e.setCancelled(true);
				/* 890 */ p.closeInventory();
				/* 891 */ p.chat("/kit specialist");
				/* 892 */ return;
				/*      */ }
			/* 901 */ if (e.getCurrentItem().getType() == Material.WOODEN_HOE)
			/*      */ {
				/* 903 */ e.setCancelled(true);
				/* 904 */ p.closeInventory();
				/* 905 */ p.chat("/kit reaper");
				/* 906 */ return;
				/*      */ }
			/* 915 */ if (e.getCurrentItem().getType() == Material.COBWEB)
			/*      */ {
				/* 917 */ e.setCancelled(true);
				/* 918 */ p.closeInventory();
				/* 919 */ p.chat("/kit snail");
				/* 920 */ return;
				/*      */ }
			/* 985 */ if (e.getCurrentItem().getType() == Material.MAGMA_CREAM)
			/*      */ {
				/* 987 */ e.setCancelled(true);
				/* 988 */ p.closeInventory();
				/* 989 */ p.chat("/kit booster");
				/* 990 */ return;
				/*      */ }
			/* 985 */ if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE)
			/*      */ {
				/* 987 */ e.setCancelled(true);
				/* 988 */ p.closeInventory();
				/* 989 */ p.chat("/kit madman");
				/* 990 */ return;
				/*      */ }
			/* 1020 */ if (e.getCurrentItem().getType() == Material.IRON_HOE)
			/*      */ {
				/* 1022 */ e.setCancelled(true);
				/* 1023 */ p.closeInventory();
				/* 1024 */ p.chat("/kit bloodgun");
				/* 1025 */ return;
				/*      */ }
			/* 1020 */ if (e.getCurrentItem().getType() == Material.IRON_BOOTS)
			/*      */ {
				/* 1022 */ e.setCancelled(true);
				/* 1023 */ p.closeInventory();
				/* 1024 */ p.chat("/kit stomper");
				/* 1025 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.POTION)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit urgal");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.STONE_AXE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit thor");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.SNOWBALL)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit switcher");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.TNT)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit tank");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.CLOCK)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit timelord");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit turtle");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.SPIDER_EYE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit viper");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.DIRT)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit worm");
				/* 1032 */ return;
				/*      */ }
			/* 1027 */ if (e.getCurrentItem().getType() == Material.SPONGE)
			/*      */ {
				/* 1029 */ e.setCancelled(true);
				/* 1030 */ p.closeInventory();
				/* 1031 */ p.chat("/kit launcher");
				/* 1032 */ return;
				/*      */ }
			/*      */ }
		/*      */ }
	/*      */ }

/*
 * Location: C:\Users\not\Desktop\HungerGames.jar!\me\duex\GUI\GUI1.class Java
 * compiler version: 7 (51.0) JD-Core Version: 0.7.1
 */