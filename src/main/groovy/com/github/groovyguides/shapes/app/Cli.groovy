package com.github.groovyguides.shapes.app

/**
 *
 *
 * @author Duncan Dickinson
 */
class Cli {

    static public final String VERSION = '0.1.0'

    static private final CliBuilder CB = new CliBuilder(usage:'')

    ; {
        CB.with {
            h longOpt:'help', 'Show usage information'
            v longOpt:'version', 'Show the current version of the application'
        }
    }
  
  static void cliError(text) {
		System.err << text + "\n"
		System.exit(1)
	}

    static void main(args) {
        OptionAccessor options = CB.parse(args)

        if (!options) {
            cliError('Error: No options provided')
        }

        if (options.h) {
            CB.usage()
            System.exit(0)
        }

        if (options.v) {
            println VERSION
            System.exit(0)
        }

        System.exit(0)
    }
}
