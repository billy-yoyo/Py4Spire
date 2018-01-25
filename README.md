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

