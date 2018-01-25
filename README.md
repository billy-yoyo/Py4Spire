# Py4Spire

Support for Jython mods in Slay the Spire

## Examples and Tutorials

Not many of these yet, will work on some more when I get the chance.
Look at /pymods for an example mod structure

## pymods folder structure

A mod in the pymods folder consits of the following:
a `.json` file of the following structure:
```
{
    "name": "name of your mod",
    "folder": "the folder of your mod (inside pymods)",
    "components": [
        {
            "type": "component type, e.g. relic or card",
            "file": "the file import path for this component, relative to this mods folder, e.g. example_relic or relics.fire_hand",
            "name": "the name of the class for this component, within that file, e.g. ExampleRelic or FireHand"
        },
        ...
    ]
}
```

## Compiling

I'll get round to uploading a compiled jar to the repo soon, it should be compatibly with any normal java mod launcher, and most mods since it's very unintrusive.

If you want to try and compile it yourself, it has jython as a dependancy

## How does it work

When loading the game it looks through the `/pymods` folder for `.json` files, reads them, loads the components defined in them, and registers them to the game's internal libraries. It uses Jython to load the python classes in the java.

Jython does a lot of caching of files to speed things up, so the first time you run with Py4Spire it'll take quite a while to load, but after the first time you shouldn't see any difference in load speeds, it's lightning fast!