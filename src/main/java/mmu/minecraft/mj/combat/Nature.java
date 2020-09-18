package mmu.minecraft.mj.combat;

/**
 * Weakness Chart:
 * Nether > Overworld > Void > Aether > Nether
 * 
 * - Nether will destroy Overworld with insane destructive power
 * - Aether will parry and avoid all Nether's deadly power
 * - Void will slowly corrupt and consume Aether
 * - Overworld will purify the Void
 */

public enum Nature {
  /* No nature, nothing special about it */
  NORMAL,
  /* A nature that restores and cures (buff and heal) */
  OVERWORLD,
  /* A nature that focus on destructive power */
  NETHER,
  /* A nature that foster ones agility and speed */
  AETHER,
  /* A nature that brings curses (debuff and alignments) */
  VOID
}
