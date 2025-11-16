Mortal Kombat Console Game (Java)

This project is a small console-based combat game inspired by classic Mortal Kombat mechanics.
The player fights an infinite wave of enemies, gaining power after every victory.
The project demonstrates several object-oriented design patterns and a clean modular architecture.

The game includes heroes, enemies, actions, strategies, decorators, observers and factories.
Combat logic is managed through a dedicated facade that keeps the main class simple.

Gameplay overview:
The player chooses actions each turn.
Available actions include a normal attack, a defensive stance, a critical hit that ignores armor and a vampire attack that heals the hero based on the damage dealt.
The enemy uses a strategy to decide its own action. After each victory, the hero’s attributes increase and a stronger opponent appears.

Key features:
Hero and enemy classes with dynamic stats and health.
Battle strategies that control enemy behavior.
Action decorators that modify attacks and defenses.
Observer that reports battle events.
Character and enemy factories.
Game facade that handles battle flow and wave progression.
Vampire and critical hit mechanics with RNG.
Scaling difficulty through enemy waves.

This project is designed as a demonstration of object oriented design, pattern usage and clean separation of responsibilities.
It can be extended with new heroes, abilities, enemy types or a graphical interface in the future.
