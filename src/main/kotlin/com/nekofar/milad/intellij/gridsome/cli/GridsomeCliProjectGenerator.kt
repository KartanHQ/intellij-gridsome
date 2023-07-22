package com.nekofar.milad.intellij.gridsome.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.gridsome.GridsomeBundle.message
import com.nekofar.milad.intellij.gridsome.GridsomeIcons

class GridsomeCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "@gridsome/cli"
    private val npxCommand = "gridsome"

    override fun getName() = message("gridsome.project.generator.name")

    override fun getDescription() = message("gridsome.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile) = emptyArray<Filter>()

    override fun customizeModule(virtualFile: VirtualFile, contentEntry: ContentEntry?) {}

    override fun packageName() = packageName

    override fun presentablePackageName() = message("gridsome.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName, npxCommand))

    override fun generateInTemp() = true

    override fun generatorArgs(project: Project, baseDir: VirtualFile) = arrayOf("create", project.name)

    override fun getIcon() = GridsomeIcons.ProjectGenerator
}
